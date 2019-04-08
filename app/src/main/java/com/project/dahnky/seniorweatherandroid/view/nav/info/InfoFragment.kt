package com.project.dahnky.seniorweatherandroid.view.nav.info

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.dahnky.seniorweatherandroid.R
import com.project.dahnky.seniorweatherandroid.core.CoreFragment
import com.project.dahnky.seniorweatherandroid.model.ResourceInformation
import com.project.dahnky.seniorweatherandroid.view.adapters.ResourcesAdapter
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.content_info.*

class InfoFragment : CoreFragment<InfoPresenter>(), IInfoView {

    companion object {
        fun newInstance() = InfoFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.start()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun setResources(resources: List<ResourceInformation>) {
        rv_resources.adapter = ResourcesAdapter(presenter, resources)
    }

    private fun setupView() {
        rv_resources.layoutManager = LinearLayoutManager(activity)
        presenter.start()
    }
}