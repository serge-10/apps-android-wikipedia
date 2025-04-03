package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class InTheNewsItem(matcher: Matcher<View>) : KRecyclerItem<InTheNewsItem>(matcher) {
    val headerTitle = KTextView(matcher){
        withId(R.id.view_card_header_title)
    }
    val menuImage = KImageView(matcher){
        withId(R.id.view_list_card_header_menu)
    }
    val newsCardViewItems = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.news_cardview_recycler_view)
        },
        itemTypeBuilder = {
            itemType(::NewsCardViewItem)
        }

    )
}