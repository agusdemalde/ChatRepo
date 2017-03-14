dataSource {
    pooled = true
    jmxExport = true
    driverClassName = "com.mysql.jdbc.Driver"
	dialect="org.hibernate.dialect.MySQL5InnoDBDialect"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory'
}

environments {
    development {
        dataSource {
            dbCreate = "update" 
            url = "jdbc:mysql://localhost:3306/chats"
			username = "root"
			password = "demalde_5"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
			url = "jdbc:mysql://localhost:3306/chats"
			username = "root"
			password = "demalde_5"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
			url = "jdbc:mysql://localhost:3306/chats"
			username = "root"
			password = "demalde_5"
        }
    }
}

