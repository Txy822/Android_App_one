package com.example.my_application_one;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.PositionAssertions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;

import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BritishLibraryTest {

    @Rule
    public ActivityScenarioRule<BritishLibrary> activityRule = new ActivityScenarioRule <>(BritishLibrary.class);

    @Test
    public void checkLayout() {
        onView(withId(R.id.borrowLabel)).check(matches(isDisplayed()));
        onView(withId(R.id.borrowID)).check(matches(isDisplayed()));
        onView(withId(R.id.setBorrowerID)).check(matches(isDisplayed()));

        onView(withId(R.id.borrowLabel)).check(isCompletelyAbove(withId(R.id.borrowID)));
        onView(withId(R.id.borrowLabel)).check(isCompletelyAbove(withId(R.id.setBorrowerID)));
        onView(withId(R.id.borrowID)).check(isCompletelyAbove(withId(R.id.setBorrowerID)));

    }
}
