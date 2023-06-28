package com.example.toys_servlet.daos;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.toys_servlet.commons.Commons;

public class OptionInforsDao {
    //로그인
// public boolean verifyLogin(String respondentsId, String password) throws SQLException {
//     // Get the database connection from the Commons object
//     Commons commons = new Commons();
//     Connection connection = commons.getConnection();

//     // Prepare the SQL statement to fetch users from the database
//     String sql = "SELECT * FROM users WHERE respondentsId = ? AND password = ?";
//     PreparedStatement statement = connection.prepareStatement(sql);
//     statement.setString(1, respondentsId);
//     statement.setString(2, password);

//     // Execute the query
//     ResultSet resultSet = statement.executeQuery();

//     // Check if user exists
//     boolean loginSuccessful = resultSet.next();

//     // Close database resources
//     resultSet.close();
//     statement.close();

//     return loginSuccessful;
// }

    //통계
    public HashMap<String, Object> getStatistics() {
        HashMap<String, Object> optionInfoRecord = new HashMap<>(); // 결과를 저장할 빈 HashMap 객체 생성
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement();
            //총설문자수 query
            String query = "SELECT COUNT(DISTINCT RESPONDENTS_ID) AS TotalCount FROM statistics;";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                // count 값을 optionInfoRecord HashMap에 저장   
                int totalCount = resultSet.getInt("TotalCount"); 
                optionInfoRecord.put("TotalCount", totalCount);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return optionInfoRecord;
    }
   
    
    //문항
    
    //상세보기를 위한 select 메서드
        public HashMap SelectWithUniqueId(String unique_id) {
        HashMap optionInforRecord = new HashMap<>();  // 빈 HashMap 객체를 생성합니다. 결과저장
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement();
            //unique_id를 기반으로 respondents 테이블에서 레코드를 선택
            String query = "SELECT * FROM respondents WHERE RESPONDENTS_ID = '" + unique_id + "';";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) { 
                // 결과를 optionInforRecord HashMap에 저장
                optionInforRecord.put("RESPONDENTS_ID", resultSet.getString("RESPONDENTS_ID"));
                optionInforRecord.put("RESPONDENTS", resultSet.getString("RESPONDENTS"));
                optionInforRecord.put("PASSWORD", resultSet.getString("PASSWORD"));
            }
            /* if (resultSet.next())은 .ResultSet에 적어도 하나의 데이터 행이 있는지 확인. 
            조건 resultSet.next()가 true로 평가되면 ResultSet에 사용 가능한 데이터 행이 있고 if 블록 내부의 코드가 실행됨 */

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return optionInforRecord;
    }
    
    //Delete 메서드
    public static int DeleteWithUniqueID(String unique_id) {
        int count = 0;
        try {
            Commons commons = new Commons();
            Statement statement = commons.getStatement(); // workbench에서 작성한 쿼리를 실행하는 객체
            String query = "DELETE FROM respondents\n" + //
                    "where RESPONDENTS_ID = '"+unique_id+"';"; // unique_id를 기준으로 레코드 삭제하는 쿼리
            count = statement.executeUpdate(query); // 쿼리 실행 결과로 영향 받은 레코드의 개수를 반환
        } catch (Exception e) {
            System.out.println(e.getMessage()); // 예외 발생 시 메시지 출력
        }
        return count; // 삭제된 레코드 개수 반환
    }

    // search를 기준으로 OptionInfors 테이블에서 레코드를 조회하는 메서드
    public ArrayList SelectWithSearch(String search) {
        ArrayList optionInforList = new ArrayList(); // 조회된 옵션 정보를 담을 ArrayList 객체 생성
        try {
            if (search == null) {
                search = ""; // search가 null이면 빈 문자열로 초기화
            }
            Commons commons = new Commons();
            Statement statement = commons.getStatement(); // workbench에서 작성한 쿼리를 실행하는 객체
            String query = "SELECT *\n" + //
                    "FROM respondents\n" + //
                    "WHERE RESPONDENTS like '" + search + "%';"; // search를 포함하는 RESPONDENTS 레코드를 조회하는 쿼리
            ResultSet resultSet = statement.executeQuery(query); // 쿼리 실행 결과로 ResultSet 객체 반환

            HashMap optionInforRecord = new HashMap<>(); // 조회된 각 레코드를 담을 HashMap 객체 생성
            while (resultSet.next()) { // ResultSet 객체의 레코드를 순회
                optionInforRecord = new HashMap<>(); // 새로운 HashMap 객체 생성
                optionInforRecord.put("RESPONDENTS_ID", resultSet.getString("RESPONDENTS_ID")); // RESPONDENTS_ID를 키로하여 값을 저장
                optionInforRecord.put("RESPONDENTS", resultSet.getString("RESPONDENTS")); // RESPONDENTS을 키로하여 값을 저장

                optionInforList.add(optionInforRecord); // 조회된 레코드를 optionInforList에 추가
            }
        } catch (Exception e) {
            System.out.println(e.getMessage()); // 예외 발생 시 메시지 출력
        }
        return optionInforList; // 조회된 옵션 정보 리스트 반환
    }
}