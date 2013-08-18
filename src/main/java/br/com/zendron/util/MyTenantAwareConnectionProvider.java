package br.com.zendron.util;

import org.hibernate.internal.util.jndi.JndiHelper;
import org.hibernate.service.jdbc.connections.spi.ConnectionProvider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Zendron
 * Date: 17/08/13
 * Time: 22:32
 * To change this template use File | Settings | File Templates.
 */
public class MyTenantAwareConnectionProvider implements ConnectionProvider {
    public static final String BASE_JNDI_NAME_PARAM = "MyTenantAwareConnectionProvider.baseJndiName";

    private String baseJndiName;

    public void configure(Properties props) {
        baseJndiName = props.getProperty(BASE_JNDI_NAME_PARAM);
    }

    @Override
    public Connection getConnection() throws SQLException {
        final String tenantId = "banco1";
        final String tenantDataSourceName = baseJndiName + '/' + tenantId;
        //DataSource tenantDataSource = new Da
        return null;
    }

    @Override
    public void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return true;
    }

    @Override
    public boolean isUnwrappableAs(Class unwrapType) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> T unwrap(Class<T> unwrapType) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
