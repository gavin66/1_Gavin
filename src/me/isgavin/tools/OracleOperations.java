package me.isgavin.tools;

public class OracleOperations {
	//写入clob大字段的方法
//    public void writeClob(HttpServletBean hsBean,String tablename,String id,String column,String value) throws Exception {
//    	Writer outStream = null;
//    	int count = hsBean.getStatement().executeUpdate("update "+tablename+" set " + column + "=empty_clob() where id='"+id+"'");
//    	if(count > 0){
//    		hsBean.conautosubmit(false);
//    		Statement stmt = hsBean.getStatement();
//    		ResultSet rs = stmt.executeQuery("select " + column + " from " + tablename + " where ID= " + id + " for update");
//    		while(rs.next()){
//    			oracle.sql.CLOB clob = (oracle.sql.CLOB) rs.getClob(column);
//    			outStream = clob.getCharacterOutputStream();
//    			char[] c = value.toCharArray();
//    			outStream.write(c, 0, c.length);
//        		outStream.close();
//        		stmt.execute("commit");
//    		}
//    		hsBean.conautosubmit(true);
//    	}
//    }
}
