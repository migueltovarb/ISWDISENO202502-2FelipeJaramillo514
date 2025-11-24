package com.sga.config;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SequenceGeneratorService {

    private final MongoOperations mongoOperations;

    public int generateSequence(String seqName) {
        Query query = new Query(Criteria.where("_id").is(seqName));
        Update update = new Update().inc("seq", 1);

        DatabaseSequence counter = mongoOperations.findAndModify(
                query,
                update,
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                DatabaseSequence.class
        );

        long sequence = counter != null ? counter.getSeq() : 1L;
        return (int) sequence;
    }
}
