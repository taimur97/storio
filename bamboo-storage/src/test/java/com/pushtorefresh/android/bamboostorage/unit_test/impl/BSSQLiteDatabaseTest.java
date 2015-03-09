package com.pushtorefresh.android.bamboostorage.unit_test.impl;

import android.database.sqlite.SQLiteDatabase;

import com.pushtorefresh.android.bamboostorage.BambooStorage;
import com.pushtorefresh.android.bamboostorage.impl.BSSQLiteDatabase;
import com.pushtorefresh.android.bamboostorage.query.RawQuery;
import com.pushtorefresh.android.bamboostorage.query.RawQueryBuilder;

import org.junit.Test;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BSSQLiteDatabaseTest {

    @Test public void internalExecSql() {
        final SQLiteDatabase db = mock(SQLiteDatabase.class);

        final BambooStorage bambooStorage = new BSSQLiteDatabase.Builder()
                .db(db)
                .build();

        final RawQuery rawQuery = new RawQueryBuilder().query("ALTER TABLE users").build();

        bambooStorage.internal().execSql(rawQuery);

        verify(db, times(1)).execSQL(eq(rawQuery.query), eq(rawQuery.args));
    }
}