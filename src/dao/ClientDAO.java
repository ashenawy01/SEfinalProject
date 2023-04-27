//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dao;

import entity.Client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private final String url = "jdbc:derby:Database/LAWFIRMDB;";

    public ClientDAO() {
    }

    public boolean save(Client client) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby:Database/LAWFIRMDB;");

            boolean var6;
            try {
                Statement stmt = conn.createStatement();

                try {
                    String sql = "INSERT INTO CLIENT (firstName, lastName, phoneNo) VALUES(?,?,?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, client.getFirstName());
                    pstmt.setString(2, client.getLastName());
                    pstmt.setString(3, client.getPhoneNo());
                    var6 = pstmt.executeUpdate() > 0;
                } catch (Throwable var9) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var8) {
                            var9.addSuppressed(var8);
                        }
                    }

                    throw var9;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var10) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var7) {
                        var10.addSuppressed(var7);
                    }
                }

                throw var10;
            }

            if (conn != null) {
                conn.close();
            }

            return var6;
        } catch (SQLException var11) {
            var11.printStackTrace();
            return false;
        }
    }

    public <T> Client findClientById(T object, int id) {
        Client client = null;

        try {
            Connection connection = DriverManager.getConnection("jdbc:derby:Database/LAWFIRMDB;");

            try {
                Statement statement = connection.createStatement();

                try {
                    String sql = "Select * FROM CLIENT WHERE ID = " + id;
                    ResultSet resultSet = statement.executeQuery(sql);
                    if (resultSet.next()) {
                        ((Client)client).setClientID(resultSet.getInt("ID"));
                        ((Client)client).setFirstName(resultSet.getString("FIRSTNAME"));
                        ((Client)client).setLastName(resultSet.getString("LASTNAME"));
                        ((Client)client).setPhoneNo(resultSet.getString("PHONENO"));
                    }
                } catch (Throwable var10) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var9) {
                            var10.addSuppressed(var9);
                        }
                    }

                    throw var10;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var11) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var8) {
                        var11.addSuppressed(var8);
                    }
                }

                throw var11;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var12) {
            var12.printStackTrace();
        }

        return (Client)client;
    }

    public boolean deleteUserById(int id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:derby:Database/LAWFIRMDB;");

            boolean var5;
            try {
                Statement statement = connection.createStatement();

                try {
                    String sql = "DELETE FROM CLIENT WHERE ID =" + id;
                    var5 = statement.executeUpdate(sql) > 0;
                } catch (Throwable var9) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var8) {
                            var9.addSuppressed(var8);
                        }
                    }

                    throw var9;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var10) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var7) {
                        var10.addSuppressed(var7);
                    }
                }

                throw var10;
            }

            if (connection != null) {
                connection.close();
            }

            return var5;
        } catch (SQLException var11) {
            var11.printStackTrace();
            return false;
        }
    }

    public boolean updateUserById(int id, Client newClient) {
        String sql = "UPDATE CLIENT FIRSTNAME = ?, LASTNAME = ?, PHONENO = ?WHERE ID = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:derby:Database/LAWFIRMDB;");

            boolean var6;
            try {
                PreparedStatement pstmt = connection.prepareStatement(sql);

                try {
                    pstmt.setString(1, newClient.getFirstName());
                    pstmt.setString(2, newClient.getLastName());
                    pstmt.setString(3, newClient.getPhoneNo());
                    pstmt.setInt(4, id);
                    var6 = pstmt.executeUpdate() > 0;
                } catch (Throwable var11) {
                    if (pstmt != null) {
                        try {
                            pstmt.close();
                        } catch (Throwable var10) {
                            var11.addSuppressed(var10);
                        }
                    }

                    throw var11;
                }

                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Throwable var12) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var9) {
                        var12.addSuppressed(var9);
                    }
                }

                throw var12;
            }

            if (connection != null) {
                connection.close();
            }

            return var6;
        } catch (SQLException var13) {
            var13.printStackTrace();
            return false;
        }
    }

    public <T> List<Client> findAll(T object) {
        List<Client> clients = new ArrayList();
        String sql = "select * from CLIENT";
        Client client = null;

        try {
            Connection connection = DriverManager.getConnection("jdbc:derby:Database/LAWFIRMDB;");

            try {
                Statement statement = connection.createStatement();

                try {
                    ResultSet resultSet = statement.executeQuery(sql);

                    while(resultSet.next()) {
                        ((Client)client).setClientID(resultSet.getInt("ID"));
                        ((Client)client).setFirstName("FIRSTNAME");
                        ((Client)client).setLastName("LASTNAME");
                        ((Client)client).setPhoneNo("PHONENO");
                    }
                } catch (Throwable var11) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var10) {
                            var11.addSuppressed(var10);
                        }
                    }

                    throw var11;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var12) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var9) {
                        var12.addSuppressed(var9);
                    }
                }

                throw var12;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var13) {
            var13.printStackTrace();
        }

        return clients;
    }
}
