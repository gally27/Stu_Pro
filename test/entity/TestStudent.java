package entity;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestStudent {
	
	@Test
	public void testSchemaExport() {
		Configuration config = new Configuration().configure();
		//ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		//Session session = sessionFactory.getCurrentSession();
		SchemaExport  export = new SchemaExport(config);
		export.create(true,true);
	}
}
