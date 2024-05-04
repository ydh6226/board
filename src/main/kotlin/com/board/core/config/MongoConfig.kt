package com.board.core.config

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.MongoTransactionManager
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.core.convert.MongoConverter
import org.springframework.data.mongodb.core.mapping.MongoMappingContext

@EnableMongoAuditing
@Configuration
class MongoConfig {

    @Bean
    @ConditionalOnMissingBean(MongoConverter::class)
    fun mappingMongoConverter(
        mongoDatabaseFactory: MongoDatabaseFactory,
        mongoMappingContext: MongoMappingContext
    ): MappingMongoConverter {
        val defaultDbRefResolver = DefaultDbRefResolver(mongoDatabaseFactory)
        return MappingMongoConverter(defaultDbRefResolver, mongoMappingContext).apply {
            setTypeMapper(DefaultMongoTypeMapper(null))
        }
    }

    @Bean
    fun mongoTransactionManager(mongoDatabaseFactory: MongoDatabaseFactory): MongoTransactionManager {
        return MongoTransactionManager(mongoDatabaseFactory)
    }
}