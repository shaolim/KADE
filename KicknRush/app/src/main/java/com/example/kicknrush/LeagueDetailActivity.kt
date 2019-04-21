package com.example.kicknrush

import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.kicknrush.model.League
import org.jetbrains.anko.*

class LeagueDetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_LEAGUE = "Extra League"
    }

    lateinit var nameTextView: TextView
    lateinit var posterImageView: ImageView
    lateinit var descriptionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league_detail)

        verticalLayout {
            padding = dip(16)
            backgroundColor = Color.GRAY

            nameTextView = textView {
                textAlignment = View.TEXT_ALIGNMENT_CENTER
                textSize = 24f
                textColor = Color.WHITE
                typeface = Typeface.DEFAULT_BOLD
            }

            posterImageView = imageView()
                .lparams(width = matchParent) {
                    padding = dip(20)
                    margin = dip(15)
                }

            scrollView {
                descriptionTextView = textView {
                    textColor = Color.WHITE
                    textSize = 18f
                }
            }
        }

        val intent = intent
        val league: League = intent.getParcelableExtra(EXTRA_LEAGUE)
        nameTextView.text = league.name
        league.image?.let { posterImageView.setImageResource(it) }
        descriptionTextView.text = league.description
    }
}
