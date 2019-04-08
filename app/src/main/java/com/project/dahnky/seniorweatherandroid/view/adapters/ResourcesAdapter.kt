package com.project.dahnky.seniorweatherandroid.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.project.dahnky.seniorweatherandroid.model.ResourceInformation
import com.project.dahnky.seniorweatherandroid.view.custom.resource.ResourceRowListener
import com.project.dahnky.seniorweatherandroid.view.custom.resource.ResourceRowView

class ResourcesAdapter(private val listener: ResourceRowListener,
                       private val resources: List<ResourceInformation>) : RecyclerView.Adapter<ResourcesAdapter.ResourcesViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ResourcesViewHolder {
        return ResourcesViewHolder(ResourceRowView((viewGroup.context)))
    }

    override fun getItemCount(): Int {
        return resources.size
    }

    override fun onBindViewHolder(holder: ResourcesViewHolder, position: Int) {
        holder.rowView.setup(resources[position], listener)
    }

    class ResourcesViewHolder(val rowView: ResourceRowView) : RecyclerView.ViewHolder(rowView)

}
