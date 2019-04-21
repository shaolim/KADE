package com.example.kicknrush

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.kicknrush.model.League
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var leagues: MutableList<League> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        league_list.layoutManager = LinearLayoutManager(this)
        league_list.adapter = LeagueAdapter(this, leagues) {
            startActivity<LeagueDetailActivity>(LeagueDetailActivity.EXTRA_LEAGUE to it)
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.league_name)
        val image = resources.obtainTypedArray(R.array.league_image)
        val description = resources.getStringArray(R.array.league_description)
        leagues.clear()
        for (i in name.indices) {
            leagues.add(League(name[i], image.getResourceId(i, 0), description[i]))
        }

        image.recycle()
    }
}
