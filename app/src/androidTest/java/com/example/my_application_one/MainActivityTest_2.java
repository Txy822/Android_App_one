package com.example.my_application_one;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import com.example.my_application_one.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest_2 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest_2() {
        ViewInteraction materialButton = onView(
allOf(withId(R.id.button), withText("Update"),
childAtPosition(
childAtPosition(
withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
0),
1),
isDisplayed()));
        materialButton.perform(click());
        
        ViewInteraction appCompatSpinner = onView(
allOf(withId(R.id.spinner),
childAtPosition(
childAtPosition(
withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
0),
2),
isDisplayed()));
        appCompatSpinner.perform(click());
        
        DataInteraction materialTextView = onData(anything())
.inAdapterView(childAtPosition(
withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
0))
.atPosition(0);
        materialTextView.perform(click());
        
        ViewInteraction materialButton2 = onView(
allOf(withId(R.id.button), withText("Update"),
childAtPosition(
childAtPosition(
withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
0),
1),
isDisplayed()));
        materialButton2.perform(click());
        
        ViewInteraction materialButton3 = onView(
allOf(withId(R.id.send), withText("Send Message"),
childAtPosition(
childAtPosition(
withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
0),
3),
isDisplayed()));
        materialButton3.perform(click());
        
        ViewInteraction appCompatEditText = onView(
allOf(withId(R.id.message),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatEditText.perform(replaceText("ettrere"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText2 = onView(
allOf(withId(R.id.message), withText("ettrere"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
1),
isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());
        
        ViewInteraction materialButton4 = onView(
allOf(withId(R.id.send), withText("Send Message"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
0),
isDisplayed()));
        materialButton4.perform(click());
        
        pressBack();
        
        pressBack();
        
        ViewInteraction materialButton5 = onView(
allOf(withId(R.id.britishLibrary), withText("British Library"),
childAtPosition(
childAtPosition(
withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
0),
5),
isDisplayed()));
        materialButton5.perform(click());
        
        ViewInteraction materialButton6 = onView(
allOf(withId(R.id.setBorrowerID), withText("Set Borrower ID"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        materialButton6.perform(click());
        
        pressBack();
        
        ViewInteraction materialButton7 = onView(
allOf(withId(R.id.stopClock), withText("StopClock"),
childAtPosition(
childAtPosition(
withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
0),
4),
isDisplayed()));
        materialButton7.perform(click());
        
        ViewInteraction materialButton8 = onView(
allOf(withId(R.id.start), withText("Start"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()));
        materialButton8.perform(click());
        
        ViewInteraction materialButton9 = onView(
allOf(withId(R.id.stop), withText("Stop"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
3),
isDisplayed()));
        materialButton9.perform(click());
        
        pressBack();
        }
    
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup)parent).getChildAt(position));
            }
        };
    }
    }
