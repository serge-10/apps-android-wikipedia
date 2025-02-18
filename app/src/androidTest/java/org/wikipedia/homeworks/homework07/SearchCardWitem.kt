package org.wikipedia.homeworks.homework07

import android.view.View
import androidx.test.espresso.DataInteraction
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.recycler.KRecyclerItemTypeBuilder
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.hamcrest.Matcher
import org.wikipedia.exampies.KImageView

class SearchCardWitem(matcher: Matcher<View>,

) : KRecyclerView<SearchCardWitem>(Matcher) {
    val searchIcon = KImageView(matcher){

    }
}