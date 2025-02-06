package org.wikipedia.homeworks.homework03


import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatEditText
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputEditText
import org.wikipedia.views.AppTextView

// Кнопки онбординга
val skipButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_skip_button",
    "onboarding_skip"
)

val continueButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_forward_button",
    "onboarding_continue"
)

val addOrEditLanguages = listOf(
    MaterialButton::class.java,
    "addLanguageButton",
    "onboarding_multilingual_add_language_text"
)

// Индикатор страниц онбординга
val pageIndicator = listOf(
    TabLayout::class.java,
    "view_onboarding_page_indicator"
)

// Список языков
val languagesList = listOf(
    RecyclerView::class.java,
    "languagesList",
    listOf(AppTextView::class.java, "option_label")
)

// Текстовые элементы онбординга
val firstLineText = listOf(
    AppTextView::class.java,
    "primaryTextView",
    "onboarding_primary_text"
)

val secondLineText = listOf(
    AppTextView::class.java,
    "secondaryTextView",
    "onboarding_secondary_text"
)

// Главное изображение онбординга
val mainImage = listOf(
    AppCompatImageView::class.java,
    "onboarding_image"
)

// === Элементы нового экрана ===

// Логотип Wikipedia
val wikipediaLogo = listOf(
    AppCompatImageView::class.java,
    "main_toolbar_wordmark"
)

// Поле поиска
val searchField = listOf(
    TextInputEditText::class.java,
    "search_container",
    "search_hint"
)

// Кнопка голосового поиска
val voiceSearchButton = listOf(
    AppCompatImageView::class.java,
    "voice_search_button"
)

// Карточка "Customize your Explore feed"
val customizeCard = listOf(
    AppTextView::class.java,
    "customize_explore_card"
)

val customizeButton = listOf(
    MaterialButton::class.java,
    "customize_button",
    "customize"
)

val gotItButton = listOf(
    MaterialButton::class.java,
    "got_it_button",
    "got_it"
)

// Нижнее навигационное меню
val bottomNavExplore = listOf(
    MaterialButton::class.java,
    "bottom_nav_explore",
    "explore"
)

val bottomNavSaved = listOf(
    MaterialButton::class.java,
    "bottom_nav_saved",
    "saved"
)

val bottomNavSearch = listOf(
    MaterialButton::class.java,
    "bottom_nav_search",
    "search"
)

val bottomNavEdits = listOf(
    MaterialButton::class.java,
    "bottom_nav_edits",
    "edits"
)

val bottomNavMore = listOf(
    MaterialButton::class.java,
    "bottom_nav_more",
    "more"
)
