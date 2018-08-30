package com.fecklefacemassive.www.education.MongoApp.Service.MongoValidation;

import com.fecklefacemassive.www.education.MongoApp.pojo.AbstractAnimeRecord;

public class MongoAnimeDetailsValidator implements MongoValidator{

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean recordExists(AbstractAnimeRecord record) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean completeRecord(AbstractAnimeRecord record) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean recordValidForWrite(AbstractAnimeRecord record, boolean confirmOverwrite) {
        return false;
    }

}