package com.android.documentsui;

import static junit.framework.Assert.fail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.android.documentsui.base.Providers;
import com.android.documentsui.base.State;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests for the specialized behaviors provided by Metrics.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class MetricsTest {
    @Test
    public void logActivityLaunch_storageAuthority_shouldNotCrash() {
        final Intent intent = new Intent(null, Uri.parse(
                "content://" + Providers.AUTHORITY_STORAGE + "/document/primary:"));
        final State state = new State();
        state.action = State.ACTION_BROWSE;
        Metrics.logActivityLaunch(InstrumentationRegistry.getTargetContext(),
                state, intent);
    }

    @Test
    public void logActivityLaunch_mediaAuthority_shouldNotCrash() {
        final Intent intent = new Intent(null, Uri.parse(
                "content://" + Providers.AUTHORITY_MEDIA + "/document/primary:"));
        final State state = new State();
        state.action = State.ACTION_BROWSE;
        Metrics.logActivityLaunch(InstrumentationRegistry.getTargetContext(),
                state, intent);
    }
}