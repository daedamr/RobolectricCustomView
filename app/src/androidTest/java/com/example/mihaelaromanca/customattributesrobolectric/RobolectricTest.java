package com.example.mihaelaromanca.customattributesrobolectric;

import android.view.ViewGroup;

import com.example.mihaelaromanca.customattributesrobolectric.activity.MyActivity;
import com.example.mihaelaromanca.customattributesrobolectric.view.CustomProgressButton;
import com.example.mihaelaromanca.customattributesrobolectric.view.TitilliumButton;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import roboguice.util.Strings;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 18)
public class RobolectricTest {
    private MyActivity activity;
    private CustomProgressButton firstTapButton;
    private TitilliumButton secondTapButton;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(MyActivity.class).create().start().resume().get();

        firstTapButton = (CustomProgressButton) activity.findViewById(R.id.first_tap_button);
        secondTapButton = (TitilliumButton) activity.findViewById(R.id.second_tap_button);
    }

    @Test
    public void testFirstButton_shouldDisplayText() throws Exception {
        String loginText = firstTapButton != null ? Strings.toString(firstTapButton.getText()) : null;
        assertThat(loginText, equalTo("Tap me"));
    }

    @Test
    public void testSecondButton_shouldDisplayText() throws Exception {
        String loginText = secondTapButton != null ? Strings.toString(secondTapButton.getText()) : null;
        assertThat(loginText, equalTo("Tap me also"));
    }
}
