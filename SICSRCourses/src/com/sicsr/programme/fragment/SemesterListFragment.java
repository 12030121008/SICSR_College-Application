package com.sicsr.programme.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sicsr.programme.R;
import com.sicsr.programme.activity.BaseActivity;
import com.sicsr.programme.adapter.SemesterAdapter;
import com.sicsr.programme.database.DbOperationResponse;
import com.sicsr.programme.database.dao.impl.SemesterDaoImpl;
import com.sicsr.programme.widget.EmptyRecyclerView;

public class SemesterListFragment extends Fragment{

	EmptyRecyclerView recyclerViewList;
	BaseActivity mActivity;
	SemesterAdapter semesterAdapter;
	//private List<BrancheDto> branchesDto;
	ImageView imgNoResult;
	ProgressBar loading;
	SemesterDaoImpl semesterDaoImpl;
	private DbOperationResponse semesterDbResponse;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_list, container,false);
	}

	@Override
	public void onResume() {
		super.onResume();
		mActivity.setTitle(getResources().getString(R.string.semesters));
	}

	@Override
	public void onViewCreated(View root, Bundle savedInstanceState) {
		super.onViewCreated(root, savedInstanceState);
		mActivity = (BaseActivity)getActivity();
		//mActivity.setTitle(getResources().getString(R.string.semesters));
		//branchesDto = new ArrayList<BrancheDto>();
		/*BrancheDto brancheDto = new BrancheDto();
		brancheDto.setName("MBA_CA");
		branchesDto.add(brancheDto);*/

		recyclerViewList = (EmptyRecyclerView) root.findViewById(R.id.cardList);
		imgNoResult = (ImageView) root.findViewById(R.id.no_result);
		imgNoResult.setVisibility(View.GONE);
		loading = (ProgressBar) root.findViewById(R.id.loading);
		loading.setVisibility(View.VISIBLE);
		recyclerViewList.setEmptyView(loading);
		recyclerViewList.setHasFixedSize(true);
		LinearLayoutManager llm = new LinearLayoutManager(mActivity);
		llm.setOrientation(LinearLayoutManager.VERTICAL);
		recyclerViewList.setLayoutManager(llm);
		//mSwipeRefreshLayout = (SwipeRefreshLayout) root.findViewById(R.id.swipeRefreshLayoutAccountsList);
		loadContent();

	}


	public void loadContent() {
		Bundle bundle = getArguments();
		if(bundle != null){
			if(bundle.containsKey("id")){


				semesterDaoImpl = new SemesterDaoImpl(mActivity);
				semesterDbResponse = semesterDaoImpl.findSemesters(bundle.getInt("id"));

				if (semesterDbResponse.getFetchedData() != null && semesterDbResponse.getFetchedData().getCount() > 0) {
					semesterAdapter = new SemesterAdapter(this,semesterDbResponse.getFetchedData());
					recyclerViewList.setAdapter(semesterAdapter);
					loading.setVisibility(View.GONE);
				} else {
					// Show from list or shoot error
					if(!semesterDbResponse.getStatus()){
						loading.setVisibility(View.GONE);
						imgNoResult.setVisibility(View.VISIBLE);
						Toast.makeText(mActivity, semesterDbResponse.getErrorString(), Toast.LENGTH_SHORT).show();
					}
				}
			}
		}
	}

}
