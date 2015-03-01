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
import com.sicsr.programme.adapter.UnitAdapter;
import com.sicsr.programme.database.DbOperationResponse;
import com.sicsr.programme.database.dao.impl.UnitDaoImpl;
import com.sicsr.programme.widget.EmptyRecyclerView;

public class UnitsListFragment extends Fragment{

	EmptyRecyclerView recyclerViewList;
	BaseActivity mActivity;
	UnitAdapter subjectAdapter;
	//private List<BrancheDto> branchesDto;
	ImageView imgNoResult;
	ProgressBar loading;
	UnitDaoImpl unitDaoImpl;
	private DbOperationResponse unitDbResponse;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_list, container,false);
	}

	@Override
	public void onResume() {
		super.onResume();
		mActivity.setTitle(getResources().getString(R.string.units));
	}

	@Override
	public void onViewCreated(View root, Bundle savedInstanceState) {
		super.onViewCreated(root, savedInstanceState);
		mActivity = (BaseActivity)getActivity();
		mActivity.setTitle(getResources().getString(R.string.units));
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

				unitDaoImpl = new UnitDaoImpl(mActivity);
				unitDbResponse = unitDaoImpl.findUnits(bundle.getInt("id"));

				if (unitDbResponse.getFetchedData() != null && unitDbResponse.getFetchedData().getCount() > 0) {
					subjectAdapter = new UnitAdapter(this,unitDbResponse.getFetchedData());
					recyclerViewList.setAdapter(subjectAdapter);
					loading.setVisibility(View.GONE);
				} else {
					// Show from list or shoot error
					if(!unitDbResponse.getStatus()){
						loading.setVisibility(View.GONE);
						imgNoResult.setVisibility(View.VISIBLE);
						Toast.makeText(mActivity, unitDbResponse.getErrorString(), Toast.LENGTH_SHORT).show();
					}
				}
			}
		}
	}

}
