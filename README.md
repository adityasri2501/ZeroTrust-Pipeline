String API_KEY = "AIzaSyDPYsMrwMeA-3rUxoNAkK5xO18iiTI44YI";
Add above line to check git leaks in D:\ZeroTrust Pipeline\src\main\java\com\zerotrust\controller\LoginController.java

 try {
            Connection conn = DBUtil.getConnection();

            // SQL Injection Vulnerability
            String query = "SELECT * FROM users WHERE username='" + username + "' AND password='" + password + "'";
            if (query == "'' or '1'='1"){
                query = null;
            }
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                return "Login Success";
            } else {
                return "Login Failed";
            }

        } catch (Exception e) {
            return "Error";
        }

add above in D:\ZeroTrust Pipeline\src\main\java\com\zerotrust\controller\LoginController.java fo sql injection to verify that the workflow is running

Connection conn = DriverManager.getConnection(
                "jdbc:h2:mem:testdb", "sa", "secure123"
        );

add above in D:\ZeroTrust Pipeline\src\main\java\com\zerotrust\util\DBUtil.java for blocker and pipeline fails

@Test
    void testLoginWithSpecialChars() {
        LoginController localcontroller = new LoginController();

        String result = localcontroller.login("!@#", "$$$");

        assertNotNull(result);
    }

intentionally deleted this add later in src/test/java/com/zerotrust/controller/LoginControllerTest.java

