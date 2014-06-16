package com.ccx.creditmanager;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks
{

	/**
	 * Fragment managing the behaviors, interactions and presentation of the navigation drawer &
	 * view pager.
	 */
	private NavigationDrawerFragment	mNavigationDrawerFragment;
	private ViewPager					mViewPager;
	private MainPagerAdapter			mPageAdapter;

	/* content Manager */
	private TransactionMaster			mCurrentMaster;
	private SparseArray<Integer>		mMasterPositionAndIndex;

	/**
	 * Used to store the last screen title. For use in {@link #restoreActionBar()}.
	 */
	private CharSequence				mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));

		// Set up the ViewPager
		mPageAdapter = new MainPagerAdapter(getSupportFragmentManager());
		mViewPager = (ViewPager) findViewById(R.id.main_pager);
		mViewPager.setAdapter(mPageAdapter);
	}

	@Override
	public void onNavigationDrawerItemSelected(int position)
	{
		// update the main content by replacing text and refreshing fragments

	}

	public void onSectionAttached(int number)
	{
		switch (number)
		{
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		}
	}

	public void restoreActionBar()
	{
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		if (!mNavigationDrawerFragment.isDrawerOpen())
		{
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void changeMaster(TransactionMaster tm)
	{
		// update current master
		mCurrentMaster = tm;

		// update title
		mTitle = tm.name;

		// update all display objects in fragments
		updateSummary();
	}

	public void updateSummary()
	{
		TextView displayName = (TextView) findViewById(R.id.text_cardName);
		TextView displayDue = (TextView) findViewById(R.id.text_cardDueDate);
		TextView displayValue = (TextView) findViewById(R.id.text_cardTotalValue);
		
		displayName.setText(mCurrentMaster.name);
		displayDue.setText(mCurrentMaster.getNextDue());
		displayValue.setText(mCurrentMaster.name);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment
	{
		/**
		 * The fragment argument representing the section number for this fragment.
		 */
		private static final String	ARG_SECTION_NUMBER	= "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber)
		{
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment()
		{}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState)
		{
			View rootView = inflater.inflate(R.layout.fragment_main, container, false);
			// TextView textView = (TextView) rootView.findViewById(R.id.section_label);
			// textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
			return rootView;
		}

		@Override
		public void onAttach(Activity activity)
		{
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
		}
	}

	public class MainPagerAdapter extends FragmentStatePagerAdapter
	{
		public MainPagerAdapter(FragmentManager fm)
		{
			super(fm);
		}

		@Override
		public Fragment getItem(int i)
		{
			Fragment fragment = new SummaryFragment();
			// Bundle args = new Bundle();

			// fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount()
		{
			return 100;
		}

		@Override
		public CharSequence getPageTitle(int position)
		{
			return "OBJECT " + (position + 1);
		}
	}

	public static class SummaryFragment extends Fragment
	{
		public static final String	ARG_OBJECT	= "object";

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState)
		{
			View rootView = inflater.inflate(R.layout.summary_fragment, container, false);
			// Bundle args = getArguments();

			return rootView;
		}
	}

}
