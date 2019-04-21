package com.example.kicknrush

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kicknrush.model.League
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.league_list.*

class LeagueAdapter(private val context: Context, private val leagues: List<League>, private val listener: (League) -> Unit)
    : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.league_list, parent, false))

    override fun getItemCount(): Int = leagues.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(leagues[position], listener)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindItem(league: League, listener: (League) -> Unit) {
            name.text = league.name
            league.image?.let { Picasso.get().load(it).into(image) }
            itemView.setOnClickListener { listener(league) }
        }
    }
}