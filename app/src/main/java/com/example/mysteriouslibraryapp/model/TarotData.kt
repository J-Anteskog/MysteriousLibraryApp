package com.example.mysteriouslibraryapp.model
import com.example.mysteriouslibraryapp.R

data class TarotMeaning(
    val upright: String,
    val reversed: String
)

data class TarotInterpretation(
    val upright: String,
    val reversed: String
)

data class TarotCard(
    val id: String,
    val name: String,
    val arcana: String,
    val imageRes: Int, // Ex: R.drawable.the_fool
    val meaning: Map<String, TarotMeaning>, // "en" -> TarotMeaning, "sv" -> TarotMeaning
    val interpretation: Map<String, TarotInterpretation>
)

object TarotCards {
    val cards: List<TarotCard> = listOf(
        TarotCard(
            id = "the_fool",
            name = "The Fool",
            arcana = "Major Arcana",
            imageRes = R.drawable.the_fool,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "New beginnings, innocence, free spirit",
                    reversed = "Recklessness, risk-taking, naiveté"
                ),
                "sv" to TarotMeaning(
                    upright = "Nya början, oskuld, fri ande",
                    reversed = "Vårdslöshet, risktagande, naivitet"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A journey awaits, full of unknown possibilities and fresh starts. Embrace the adventure with an open heart.",
                    reversed = "Beware of impulsive decisions or a lack of foresight. Ground yourself before taking the leap."
                ),
                "sv" to TarotInterpretation(
                    upright = "En resa väntar, full av okända möjligheter och nya starter. Omfamna äventyret med ett öppet hjärta.",
                    reversed = "Akta dig för impulsiva beslut eller brist på framförhållning. Grunda dig innan du tar steget."
                )
            )
        ),
        TarotCard(
            id = "the_magician",
            name = "The Magician",
            arcana = "Major Arcana",
            imageRes = R.drawable.the_magician,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Manifestation, resourcefulness, power",
                    reversed = "Manipulation, poor planning, untapped talents"
                ),
                "sv" to TarotMeaning(
                    upright = "Manifestation, påhittighet, kraft",
                    reversed = "Manipulation, dålig planering, outnyttjade talanger"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You have all the tools and skills needed to manifest your desires. Focus your will and take action.",
                    reversed = "Are you using your abilities wisely? Or are you being deceptive or unfocused?"
                ),
                "sv" to TarotInterpretation(
                    upright = "Du har alla verktyg och färdigheter som behövs för att manifestera dina önskningar. Fokusera din vilja och agera.",
                    reversed = "Använder du dina förmågor klokt? Eller är du bedräglig eller ofokuserad?"
                )
            )
        ),
        TarotCard(
            id = "the_high_priestess",
            name = "The High Priestess",
            arcana = "Major Arcana",
            imageRes = R.drawable.the_high_priestess,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Intuition, subconscious, mystery",
                    reversed = "Hidden agendas, secrets, repressed intuition"
                ),
                "sv" to TarotMeaning(
                    upright = "Intuition, undermedvetet, mystik",
                    reversed = "Dolda agendor, hemligheter, undertryckt intuition"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Listen to your inner voice and trust your intuition. There are hidden truths waiting to be revealed.",
                    reversed = "Something is being concealed, or you are ignoring your inner wisdom."
                ),
                "sv" to TarotInterpretation(
                    upright = "Lyssna på din inre röst och lita på din intuition. Det finns dolda sanningar som väntar på att avslöjas.",
                    reversed = "Något döljs, eller så ignorerar du din inre visdom."
                )
            )
        ),
        TarotCard(
            id = "the_empress",
            name = "The Empress",
            arcana = "Major Arcana",
            imageRes = R.drawable.the_empress,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Femininity, beauty, nature, abundance, fertility",
                    reversed = "Dependence, stagnation, barrenness"
                ),
                "sv" to TarotMeaning(
                    upright = "Feminitet, skönhet, natur, överflöd, fertilitet",
                    reversed = "Beroende, stagnation, ofruktbarhet"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A period of growth, creativity, and nurturing. Connect with nature and embrace your sensual side.",
                    reversed = "Feeling stuck or creatively blocked? Perhaps an unhealthy dependence is present."
                ),
                "sv" to TarotInterpretation(
                    upright = "En period av tillväxt, kreativitet och omvårdnad. Få kontakt med naturen och omfamna din sensuella sida.",
                    reversed = "Känner du dig fast eller kreativt blockerad? Kanske finns det ett osunt beroende."
                )
            )
        ),
        TarotCard(
            id = "the_emperor",
            name = "The Emperor",
            arcana = "Major Arcana",
            imageRes = R.drawable.the_emperor,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Authority, structure, control, father figure",
                    reversed = "Domination, rigidity, immaturity"
                ),
                "sv" to TarotMeaning(
                    upright = "Auktoritet, struktur, kontroll, fadersgestalt",
                    reversed = "Dominans, stelhet, omognad"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Take charge and establish order. You have the power to create stability and security.",
                    reversed = "Are you being too controlling or inflexible? Or are you struggling with a lack of discipline?"
                ),
                "sv" to TarotInterpretation(
                    upright = "Ta kontroll och skapa ordning. Du har kraften att skapa stabilitet och trygghet.",
                    reversed = "Är du för kontrollerande eller oflexibel? Eller kämpar du med brist på disciplin?"
                )
            )
        ),
        TarotCard(
            id = "the_hierophant",
            name = "The Hierophant",
            arcana = "Major Arcana",
            imageRes = R.drawable.the_hierophant,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Tradition, conformity, morality, spiritual guidance",
                    reversed = "Rebellion, subversiveness, new approaches"
                ),
                "sv" to TarotMeaning(
                    upright = "Tradition, konformitet, moral, andlig vägledning",
                    reversed = "Rebellion, subversivitet, nya tillvägagångssätt"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Seek wisdom from established institutions or mentors. Embrace tradition but remain open to new ideas.",
                    reversed = "Challenge the status quo. It may be time to break free from outdated beliefs."
                ),
                "sv" to TarotInterpretation(
                    upright = "Sök visdom från etablerade institutioner eller mentorer. Omfamna traditionen men var öppen för nya idéer.",
                    reversed = "Utmana status quo. Det kan vara dags att bryta sig loss från föråldrade övertygelser."
                )
            )
        ),
        TarotCard(
            id = "the_lovers",
            name = "The Lovers",
            arcana = "Major Arcana",
            imageRes = R.drawable.the_lovers,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Love, harmony, relationships, choices",
                    reversed = "Disharmony, imbalance, miscommunication"
                ),
                "sv" to TarotMeaning(
                    upright = "Kärlek, harmoni, relationer, val",
                    reversed = "Disharmoni, obalans, missförstånd"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A deep connection with another person or a choice that needs to be made with love and care.",
                    reversed = "Conflict in relationships or a difficult choice that may lead to disharmony."
                ),
                "sv" to TarotInterpretation(
                    upright = "En djup koppling till en annan person eller ett val som måste göras med kärlek och omsorg.",
                    reversed = "Konflikt i relationer eller ett svårt val som kan leda till disharmoni."
                )
            )
        ),
        TarotCard(
            id = "the_chariot",
            name = "The Chariot",
            arcana = "Major Arcana",
            imageRes = R.drawable.the_chariot,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Determination, willpower, control, victory",
                    reversed = "Lack of control, aggression, obstacles"
                ),
                "sv" to TarotMeaning(
                    upright = "Beslutsamhet, viljestyrka, kontroll, seger",
                    reversed = "Brist på kontroll, aggression, hinder"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Harness your willpower to overcome challenges. Success is within reach if you stay focused.",
                    reversed = "Are you losing control? Obstacles may be blocking your path; reassess your approach."
                ),
                "sv" to TarotInterpretation(
                    upright = "Använd din viljestyrka för att övervinna utmaningar. Framgång är inom räckhåll om du håller fokus.",
                    reversed = "Håller du på att tappa kontrollen? Hinder kan blockera din väg; ompröva ditt tillvägagångssätt."
                )
            )
        ),
        TarotCard(
            id = "strength",
            name = "Strength",
            arcana = "Major Arcana",
            imageRes = R.drawable.strength,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Courage, bravery, compassion, inner strength",
                    reversed = "Self-doubt, weakness, insecurity"
                ),
                "sv" to TarotMeaning(
                    upright = "Mod, tapperhet, medkänsla, inre styrka",
                    reversed = "Självtvivel, svaghet, osäkerhet"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You possess the inner strength to face any challenge. Approach situations with compassion and courage.",
                    reversed = "Are you doubting your abilities? It may be time to build your confidence and face your fears."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du besitter den inre styrkan att möta alla utmaningar. Närma dig situationer med medkänsla och mod.",
                    reversed = "Tvivel du på dina förmågor? Det kan vara dags att bygga upp ditt självförtroende och möta dina rädslor."
                )
            )
        ),
        TarotCard(
            id = "the_hermit",
            name = "The Hermit",
            arcana = "Major Arcana",
            imageRes = R.drawable.the_hermit,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Introspection, solitude, inner guidance",
                    reversed = "Isolation, loneliness, withdrawal"
                ),
                "sv" to TarotMeaning(
                    upright = "Introspektion, ensamhet, inre vägledning",
                    reversed = "Isolering, ensamhet, tillbakadragande"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Take time for self-reflection and seek inner wisdom. Solitude can lead to profound insights.",
                    reversed = "Are you isolating yourself too much? It may be time to reconnect with others."
                ),
                "sv" to TarotInterpretation(
                    upright = "Ta dig tid för självreflektion och sök inre visdom. Ensamhet kan leda till djupa insikter.",
                    reversed = "Isolerar du dig för mycket? Det kan vara dags att återknyta kontakten med andra."
                )
            )
        ),
        TarotCard(
            id = "wheel_of_fortune",
            name = "Wheel of Fortune",
            arcana = "Major Arcana",
            imageRes = R.drawable.wheel_of_fortune,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Change, cycles, fate, destiny",
                    reversed = "Bad luck, resistance to change, setbacks"
                ),
                "sv" to TarotMeaning(
                    upright = "Förändring, cykler, öde, skickelse",
                    reversed = "Otur, motstånd mot förändring, motgångar"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Embrace the cycles of life. Change is inevitable, and it can bring new opportunities.",
                    reversed = "Feeling stuck or facing setbacks? It may be time to reassess your path and adapt."
                ),
                "sv" to TarotInterpretation(
                    upright = "Omfamna livets cykler. Förändring är oundviklig, och den kan föra med sig nya möjligheter.",
                    reversed = "Känner du dig fast eller står inför motgångar? Det kan vara dags att ompröva din väg och anpassa dig."
                )
            )
        ),
        TarotCard(
            id = "justice",
            name = "Justice",
            arcana = "Major Arcana",
            imageRes = R.drawable.justice,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Fairness, truth, law, cause and effect",
                    reversed = "Dishonesty, unfairness, imbalance"
                ),
                "sv" to TarotMeaning(
                    upright = "Rättvisa, sanning, lag, orsak och verkan",
                    reversed = "Oärlighet, orättvisa, obalans"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Seek fairness and truth in your dealings. Justice will prevail.",
                    reversed = "Are you facing dishonesty or unfair treatment? It may be time to address imbalances in your life."
                ),
                "sv" to TarotInterpretation(
                    upright = "Sök rättvisa och sanning i dina angelägenheter. Rättvisan kommer att segra.",
                    reversed = "Står du inför oärlighet eller orättvis behandling? Det kan vara dags att ta itu med obalanser i ditt liv."
                )
            )
        ),
        TarotCard(
            id = "the_hanged",
            name = "The Hanged",
            arcana = "Major Arcana",
            imageRes = R.drawable.the_hanged,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Sacrifice, letting go, new perspectives",
                    reversed = "Stalling, indecision, resistance to change"
                ),
                "sv" to TarotMeaning(
                    upright = "Uppoffring, att släppa taget, nya perspektiv",
                    reversed = "Stagnation, obeslutsamhet, motstånd mot förändring"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Sometimes you must let go to gain a new perspective. Embrace the pause and reflect.",
                    reversed = "Are you resisting necessary changes? It may be time to make a decision and move forward."
                ),
                "sv" to TarotInterpretation(
                    upright = "Ibland måste du släppa taget för att få ett nytt perspektiv. Omfamna pausen och reflektera.",
                    reversed = "Gör du motstånd mot nödvändiga förändringar? Det kan vara dags att fatta ett beslut och gå vidare."
                )
            )
        ),
        TarotCard(
            id = "death",
            name = "Death",
            arcana = "Major Arcana",
            imageRes = R.drawable.death,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Transformation, endings, new beginnings",
                    reversed = "Fear of change, stagnation, resistance"
                ),
                "sv" to TarotMeaning(
                    upright = "Transformation, slut, nya början",
                    reversed = "Rädsla för förändring, stagnation, motstånd"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Embrace transformation and let go of the old to make way for the new. Endings can lead to new beginnings.",
                    reversed = "Are you resisting necessary changes? It may be time to confront your fears and embrace transformation."
                ),
                "sv" to TarotInterpretation(
                    upright = "Omfamna transformation och släpp taget om det gamla för att ge plats åt det nya. Slut kan leda till nya början.",
                    reversed = "Gör du motstånd mot nödvändiga förändringar? Det kan vara dags att konfrontera dina rädslor och omfamna transformation."
                )
            )
        ),
        TarotCard(
            id = "temperance",
            name = "Temperance",
            arcana = "Major Arcana",
            imageRes = R.drawable.temperance,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Balance, moderation, harmony, patience",
                    reversed = "Imbalance, excess, lack of long-term vision"
                ),
                "sv" to TarotMeaning(
                    upright = "Balans, måttfullhet, harmoni, tålamod",
                    reversed = "Obalans, överdrifter, brist på långsiktig vision"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Seek balance in all aspects of your life. Patience and moderation will lead to harmony.",
                    reversed = "Are you overindulging or lacking balance? It may be time to reassess your priorities."
                ),
                "sv" to TarotInterpretation(
                    upright = "Sök balans i alla aspekter av ditt liv. Tålamod och måttfullhet leder till harmoni.",
                    reversed = "Överdriver du eller saknar du balans? Det kan vara dags att ompröva dina prioriteringar."
                )
            )
        ),
        TarotCard(
            id = "the_devil",
            name = "The Devil",
            arcana = "Major Arcana",
            imageRes = R.drawable.the_devil,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Addiction, materialism, playfulness, temptation",
                    reversed = "Freedom, release, restoring control"
                ),
                "sv" to TarotMeaning(
                    upright = "Beroende, materialism, lekfullhet, frestelse",
                    reversed = "Frihet, frigörelse, återställande av kontroll"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Beware of temptations and material attachments. Are you feeling trapped by your desires?",
                    reversed = "You have the power to break free from unhealthy attachments and regain control of your life."
                ),
                "sv" to TarotInterpretation(
                    upright = "Akta dig för frestelser och materiella bindningar. Känner du dig fångad av dina önskningar?",
                    reversed = "Du har makten att bryta dig loss från osunda bindningar och återta kontrollen över ditt liv."
                )
            )
        ),
        TarotCard(
            id = "the_tower",
            name = "The Tower",
            arcana = "Major Arcana",
            imageRes = R.drawable.the_tower,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Sudden upheaval, chaos, revelation",
                    reversed = "Avoidance of disaster, fear of change"
                ),
                "sv" to TarotMeaning(
                    upright = "Plötslig omvälvning, kaos, uppenbarelse",
                    reversed = "Undvikande av katastrof, rädsla för förändring"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Prepare for a sudden change or revelation that may shake your foundations. Embrace the chaos for growth.",
                    reversed = "Are you avoiding necessary changes? It may be time to confront the truth and rebuild."
                ),
                "sv" to TarotInterpretation(
                    upright = "Förbered dig på en plötslig förändring eller uppenbarelse som kan skaka om din grund. Omfamna kaoset för att växa.",
                    reversed = "Undviker du nödvändiga förändringar? Det kan vara dags att konfrontera sanningen och bygga upp på nytt."
                )
            )
        ),
        TarotCard(
            id = "the_star",
            name = "The Star",
            arcana = "Major Arcana",
            imageRes = R.drawable.the_star,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Hope, inspiration, serenity, renewal",
                    reversed = "Lack of faith, despair, discouragement"
                ),
                "sv" to TarotMeaning(
                    upright = "Hopp, inspiration, lugn, förnyelse",
                    reversed = "Brist på tro, förtvivlan, missmod"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A time of healing and renewal. Trust in the universe and have faith in your path.",
                    reversed = "Feeling lost or discouraged? It may be time to reconnect with your inner light."
                ),
                "sv" to TarotInterpretation(
                    upright = "En tid av läkning och förnyelse. Lita på universum och ha tro på din väg.",
                    reversed = "Känner du dig vilse eller missmodig? Det kan vara dags att återknyta kontakten med ditt inre ljus."
                )
            )
        ),
        TarotCard(
            id = "the_moon",
            name = "The Moon",
            arcana = "Major Arcana",
            imageRes = R.drawable.the_moon,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Illusion, intuition, subconscious, dreams",
                    reversed = "Deception, confusion, fear"
                ),
                "sv" to TarotMeaning(
                    upright = "Illusion, intuition, undermedvetet, drömmar",
                    reversed = "Bedrägeri, förvirring, rädsla"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Trust your intuition and explore the depths of your subconscious. Beware of illusions.",
                    reversed = "Are you facing confusion or deception? It may be time to confront your fears and seek clarity."
                ),
                "sv" to TarotInterpretation(
                    upright = "Lita på din intuition och utforska djupet av ditt undermedvetna. Akta dig för illusioner.",
                    reversed = "Står du inför förvirring eller bedrägeri? Det kan vara dags att konfrontera dina rädslor och söka klarhet."
                )
            )
        ),
        TarotCard(
            id = "the_sun",
            name = "The Sun",
            arcana = "Major Arcana",
            imageRes = R.drawable.the_sun,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Joy, success, positivity, vitality",
                    reversed = "Temporary depression, lack of success"
                ),
                "sv" to TarotMeaning(
                    upright = "Glädje, framgång, positivitet, vitalitet",
                    reversed = "Tillfällig depression, brist på framgång"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A time of joy and success. Embrace positivity and let your inner light shine.",
                    reversed = "Feeling down or facing temporary setbacks? Remember that the sun will shine again."
                ),
                "sv" to TarotInterpretation(
                    upright = "En tid av glädje och framgång. Omfamna positivitet och låt ditt inre ljus lysa.",
                    reversed = "Känner du dig nedstämd eller står inför tillfälliga motgångar? Kom ihåg att solen kommer att skina igen."
                )
            )
        ),
        TarotCard(
            id = "judgement",
            name = "Judgement",
            arcana = "Major Arcana",
            imageRes = R.drawable.judgement,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Reflection, reckoning, awakening, renewal",
                    reversed = "Self-doubt, refusal of self-examination"
                ),
                "sv" to TarotMeaning(
                    upright = "Reflektion, uppgörelse, uppvaknande, förnyelse",
                    reversed = "Självtvivel, vägran att granska sig själv"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A time for reflection and self-evaluation. Embrace personal growth and transformation.",
                    reversed = "Are you avoiding self-reflection? It may be time to confront your past and embrace change."
                ),
                "sv" to TarotInterpretation(
                    upright = "En tid för reflektion och självevaluering. Omfamna personlig tillväxt och transformation.",
                    reversed = "Undviker du självrannsakan? Det kan vara dags att konfrontera ditt förflutna och omfamna förändring."
                )
            )
        ),
        TarotCard(
            id = "the_world",
            name = "The World",
            arcana = "Major Arcana",
            imageRes = R.drawable.the_world,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Completion, accomplishment, travel, integration",
                    reversed = "Lack of closure, incomplete goals"
                ),
                "sv" to TarotMeaning(
                    upright = "Slutförande, prestation, resor, integration",
                    reversed = "Brist på avslut, ofullständiga mål"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A sense of completion and fulfillment. Celebrate your achievements and embrace new journeys.",
                    reversed = "Are you feeling unfulfilled or lacking closure? It may be time to reassess your goals and seek completion."
                ),
                "sv" to TarotInterpretation(
                    upright = "En känsla av slutförande och uppfyllelse. Fira dina prestationer och omfamna nya resor.",
                    reversed = "Känner du dig ouppfylld eller saknar avslut? Det kan vara dags att ompröva dina mål och söka fullbordan."
                )
            )
        ),
        TarotCard(
            id = "ace_of_wands",
            name = "Ace of Wands",
            arcana = "Minor Arcana",
            imageRes = R.drawable.ace_of_wands,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Inspiration, new opportunities, growth",
                    reversed = "Lack of direction, delays, missed opportunities"
                ),
                "sv" to TarotMeaning(
                    upright = "Inspiration, nya möjligheter, tillväxt",
                    reversed = "Brist på riktning, förseningar, missade möjligheter"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A burst of creative energy and new beginnings. Embrace your passions and take action.",
                    reversed = "Are you feeling stuck or lacking direction? It may be time to reassess your goals and find new inspiration."
                ),
                "sv" to TarotInterpretation(
                    upright = "En explosion av kreativ energi och nya början. Omfamna dina passioner och agera.",
                    reversed = "Känner du dig fast eller saknar riktning? Det kan vara dags att ompröva dina mål och hitta ny inspiration."
                )
            )
        ),
        TarotCard(
            id = "two_of_wands",
            name = "Two of Wands",
            arcana = "Minor Arcana",
            imageRes = R.drawable.two_of_wands,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Planning, progress, discovery",
                    reversed = "Fear of change, lack of planning, indecision"
                ),
                "sv" to TarotMeaning(
                    upright = "Planering, framsteg, upptäckt",
                    reversed = "Rädsla för förändring, brist på planering, obeslutsamhet"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You are on the brink of new discoveries. Plan your next steps with confidence.",
                    reversed = "Are you hesitating to take action? It may be time to overcome your fears and make a decision."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du står på gränsen till nya upptäckter. Planera dina nästa steg med tillförsikt.",
                    reversed = "Tvekar du att agera? Det kan vara dags att övervinna dina rädslor och fatta ett beslut."
                )
            )
        ),
        TarotCard(
            id = "three_of_wands",
            name = "Three of Wands",
            arcana = "Minor Arcana",
            imageRes = R.drawable.three_of_wands,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Expansion, foresight, exploration",
                    reversed = "Lack of foresight, delays, obstacles"
                ),
                "sv" to TarotMeaning(
                    upright = "Expansion, framförhållning, utforskning",
                    reversed = "Brist på framförhållning, förseningar, hinder"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Your plans are starting to take shape. Embrace the opportunities that lie ahead.",
                    reversed = "Are you facing delays or obstacles? It may be time to reassess your plans and adapt."
                ),
                "sv" to TarotInterpretation(
                    upright = "Dina planer börjar ta form. Omfamna möjligheterna som ligger framför dig.",
                    reversed = "Står du inför förseningar eller hinder? Det kan vara dags att ompröva dina planer och anpassa dig."
                )
            )
        ),
        TarotCard(
            id = "four_of_wands",
            name = "Four of Wands",
            arcana = "Minor Arcana",
            imageRes = R.drawable.four_of_wands,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Celebration, harmony, homecoming",
                    reversed = "Lack of support, instability, conflict"
                ),
                "sv" to TarotMeaning(
                    upright = "Firande, harmoni, hemkomst",
                    reversed = "Brist på stöd, instabilitet, konflikt"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A time for celebration and harmony. Embrace the joy of community and family.",
                    reversed = "Are you feeling unsupported or facing conflicts at home? It may be time to address these issues."
                ),
                "sv" to TarotInterpretation(
                    upright = "En tid för firande och harmoni. Omfamna glädjen av gemenskap och familj.",
                    reversed = "Känner du dig osedd eller står inför konflikter hemma? Det kan vara dags att ta itu med dessa problem."
                )
            )
        ),
        TarotCard(
            id = "five_of_wands",
            name = "Five of Wands",
            arcana = "Minor Arcana",
            imageRes = R.drawable.five_of_wands,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Conflict, competition, rivalry",
                    reversed = "Avoidance of conflict, harmony, resolution"
                ),
                "sv" to TarotMeaning(
                    upright = "Konflikt, tävling, rivalitet",
                    reversed = "Undvikande av konflikt, harmoni, lösning"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You may be facing competition or conflict. Embrace the challenge and find constructive ways to resolve it.",
                    reversed = "Are you avoiding necessary conflicts? It may be time to address issues head-on for resolution."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du kan stå inför tävling eller konflikt. Omfamna utmaningen och hitta konstruktiva sätt att lösa den.",
                    reversed = "Undviker du nödvändiga konflikter? Det kan vara dags att ta itu med problem direkt för att nå en lösning."
                )
            )
        ),
        TarotCard(
            id = "six_of_wands",
            name = "Six of Wands",
            arcana = "Minor Arcana",
            imageRes = R.drawable.six_of_wands,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Victory, recognition, success",
                    reversed = "Lack of recognition, defeat, egoism"
                ),
                "sv" to TarotMeaning(
                    upright = "Seger, erkännande, framgång",
                    reversed = "Brist på erkännande, nederlag, egoism"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A time of victory and recognition for your efforts. Celebrate your achievements with humility.",
                    reversed = "Are you feeling unrecognized or defeated? It may be time to reassess your goals and approach."
                ),
                "sv" to TarotInterpretation(
                    upright = "En tid av seger och erkännande för dina ansträngningar. Fira dina prestationer med ödmjukhet.",
                    reversed = "Känner du dig oerkänd eller besegrad? Det kan vara dags att ompröva dina mål och ditt tillvägagångssätt."
                )
            )
        ),
        TarotCard(
            id = "seven_of_wands",
            name = "Seven of Wands",
            arcana = "Minor Arcana",
            imageRes = R.drawable.seven_of_wands,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Perseverance, defense, maintaining control",
                    reversed = "Giving up, lack of confidence, feeling overwhelmed"
                ),
                "sv" to TarotMeaning(
                    upright = "Uthållighet, försvar, bibehållen kontroll",
                    reversed = "Att ge upp, brist på självförtroende, att känna sig överväldigad"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Stand your ground and defend your position. Perseverance will lead to success.",
                    reversed = "Are you feeling overwhelmed or lacking confidence? It may be time to reassess your strategies."
                ),
                "sv" to TarotInterpretation(
                    upright = "Stå fast vid din ståndpunkt och försvara din position. Uthållighet leder till framgång.",
                    reversed = "Känner du dig överväldigad eller saknar självförtroende? Det kan vara dags att ompröva dina strategier."
                )
            )
        ),
        TarotCard(
            id = "eight_of_wands",
            name = "Eight of Wands",
            arcana = "Minor Arcana",
            imageRes = R.drawable.eight_of_wands,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Speed, action, quick decisions",
                    reversed = "Delays, frustration, lack of direction"
                ),
                "sv" to TarotMeaning(
                    upright = "Hastighet, handling, snabba beslut",
                    reversed = "Förseningar, frustration, brist på riktning"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Things are moving quickly. Be prepared for rapid changes and take decisive action.",
                    reversed = "Are you facing delays or frustration? It may be time to reasses your plans and find a new direction."
                ),
                "sv" to TarotInterpretation(
                    upright = "Saker rör sig snabbt. Var beredd på snabba förändringar och agera beslutsamt.",
                    reversed = "Står du inför förseningar eller frustration? Det kan vara dags att ompröva dina planer och hitta en ny riktning."
                )
            )
        ),
        TarotCard(
            id = "nine_of_wands",
            name = "Nine of Wands",
            arcana = "Minor Arcana",
            imageRes = R.drawable.nine_of_wands,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Resilience, persistence, boundaries",
                    reversed = "Exhaustion, paranoia, feeling overwhelmed"
                ),
                "sv" to TarotMeaning(
                    upright = "Resiliens, uthållighet, gränser",
                    reversed = "Utmattning, paranoia, att känna sig överväldigad"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You have the strength to persevere through challenges. Set boundaries to protect your energy.",
                    reversed = "Are you feeling exhausted or paranoid? It may be time to take a break and recharge."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du har styrkan att hålla ut genom utmaningar. Sätt gränser för att skydda din energi.",
                    reversed = "Känner du dig utmattad eller paranoid? Det kan vara dags att ta en paus och ladda om."
                )
            )
        ),
        TarotCard(
            id = "ten_of_wands",
            name = "Ten of Wands",
            arcana = "Minor Arcana",
            imageRes = R.drawable.ten_of_wands,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Burden, responsibility, hard work",
                    reversed = "Delegation, release of burdens, ease"
                ),
                "sv" to TarotMeaning(
                    upright = "Börda, ansvar, hårt arbete",
                    reversed = "Delegering, frigörelse från bördor, lättnad"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You may be carrying a heavy burden. Consider delegating tasks or finding ways to lighten your load.",
                    reversed = "Are you ready to release some responsibilities? Embrace the ease that comes with letting go."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du kanske bär på en tung börda. Överväg att delegera uppgifter eller hitta sätt att lätta på din börda.",
                    reversed = "Är du redo att släppa vissa ansvarsområden? Omfamna lättnaden som kommer med att släppa taget."
                )
            )
        ),
        TarotCard(
            id = "page_of_wands",
            name = "Page of Wands",
            arcana = "Minor Arcana",
            imageRes = R.drawable.page_of_wands,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Exploration, enthusiasm, creativity",
                    reversed = "Lack of direction, procrastination, apathy"
                ),
                "sv" to TarotMeaning(
                    upright = "Utforskning, entusiasm, kreativitet",
                    reversed = "Brist på riktning, prokrastinering, apati"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Embrace your creative side and explore new ideas. Enthusiasm will lead to exciting opportunities.",
                    reversed = "Are you feeling apathetic or lacking direction? It may be time to reignite your passions."
                ),
                "sv" to TarotInterpretation(
                    upright = "Omfamna din kreativa sida och utforska nya idéer. Entusiasm leder till spännande möjligheter.",
                    reversed = "Känner du dig apatisk eller saknar riktning? Det kan vara dags att återuppväcka dina passioner."
                )
            )
        ),
        TarotCard(
            id = "knight_of_wands",
            name = "Knight of Wands",
            arcana = "Minor Arcana",
            imageRes = R.drawable.knight_of_wands,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Adventure, impulsiveness, passion",
                    reversed = "Recklessness, impatience, lack of direction"
                ),
                "sv" to TarotMeaning(
                    upright = "Äventyr, impulsivitet, passion",
                    reversed = "Vårdslöshet, otålighet, brist på riktning"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A time for adventure and passion. Embrace spontaneity but be mindful of impulsive decisions.",
                    reversed = "Are you being reckless or impatient? It may be time to find a clearer path forward."
                ),
                "sv" to TarotInterpretation(
                    upright = "En tid för äventyr och passion. Omfamna spontanitet men var medveten om impulsiva beslut.",
                    reversed = "Är du vårdslös eller otålig? Det kan vara dags att hitta en tydligare väg framåt."
                )
            )
        ),
        TarotCard(
            id = "queen_of_wands",
            name = "Queen of Wands",
            arcana = "Minor Arcana",
            imageRes = R.drawable.queen_of_wands,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Confidence, independence, charisma",
                    reversed = "Self-doubt, jealousy, insecurity"
                ),
                "sv" to TarotMeaning(
                    upright = "Självförtroende, oberoende, karisma",
                    reversed = "Självtvivel, svartsjuka, osäkerhet"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Embrace your confidence and independence. Your charisma will attract positive energy.",
                    reversed = "Are you struggling with self-doubt or jealousy? It may be time to focus on self-love and acceptance."
                ),
                "sv" to TarotInterpretation(
                    upright = "Omfamna ditt självförtroende och oberoende. Din karisma kommer att locka till sig positiv energi.",
                    reversed = "Kämpar du med självtvivel eller svartsjuka? Det kan vara dags att fokusera på självkärlek och acceptans."
                )
            )
        ),
        TarotCard(
            id = "king_of_wands",
            name = "King of Wands",
            arcana = "Minor Arcana",
            imageRes = R.drawable.king_of_wands,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Leadership, vision, entrepreneurship",
                    reversed = "Impulsiveness, arrogance, lack of direction"
                ),
                "sv" to TarotMeaning(
                    upright = "Ledarskap, vision, entreprenörskap",
                    reversed = "Impulsivitet, arrogans, brist på riktning"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You have the vision and leadership skills to achieve your goals. Embrace your entrepreneurial spirit.",
                    reversed = "Are you being impulsive or arrogant? It may be time to reassess your leadership style and find a clearer direction."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du har visionen och ledaregenskaperna för att nå dina mål. Omfamna din entreprenörsanda.",
                    reversed = "Är du impulsiv eller arrogant? Det kan vara dags att ompröva din ledarstil och hitta en tydligare riktning."
                )
            )
        ),
        TarotCard(
            id = "ace_of_cups",
            name = "Ace of Cups",
            arcana = "Minor Arcana",
            imageRes = R.drawable.ace_of_cups,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "New love, emotional fulfillment, creativity",
                    reversed = "Blocked emotions, emptiness, lack of self-love"
                ),
                "sv" to TarotMeaning(
                    upright = "Ny kärlek, känslomässig uppfyllelse, kreativitet",
                    reversed = "Blockerade känslor, tomhet, brist på självkärlek"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A new emotional beginning or creative inspiration is on the horizon. Embrace love and compassion.",
                    reversed = "Are you feeling emotionally blocked or empty? It may be time to focus on self-love and healing."
                ),
                "sv" to TarotInterpretation(
                    upright = "En ny känslomässig början eller kreativ inspiration är i sikte. Omfamna kärlek och medkänsla.",
                    reversed = "Känner du dig känslomässigt blockerad eller tom? Det kan vara dags att fokusera på självkärlek och läkning."
                )
            )
        ),
        TarotCard(
            id = "two_of_cups",
            name = "Two of Cups",
            arcana = "Minor Arcana",
            imageRes = R.drawable.two_of_cups,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Partnership, unity, mutual respect",
                    reversed = "Disharmony, imbalance, broken relationships"
                ),
                "sv" to TarotMeaning(
                    upright = "Partnerskap, enighet, ömsesidig respekt",
                    reversed = "Disharmoni, obalans, trasiga relationer"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A strong partnership or connection is forming. Embrace unity and mutual respect.",
                    reversed = "Are you facing disharmony in a relationship? It may be time to address imbalances and communicate openly."
                ),
                "sv" to TarotInterpretation(
                    upright = "Ett starkt partnerskap eller en koppling håller på att bildas. Omfamna enighet och ömsesidig respekt.",
                    reversed = "Står du inför disharmoni i en relation? Det kan vara dags att ta itu med obalanser och kommunicera öppet."
                )
            )
        ),
        TarotCard(
            id = "three_of_cups",
            name = "Three of Cups",
            arcana = "Minor Arcana",
            imageRes = R.drawable.three_of_cups,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Celebration, friendship, community",
                    reversed = "Overindulgence, isolation, lack of support"
                ),
                "sv" to TarotMeaning(
                    upright = "Firande, vänskap, gemenskap",
                    reversed = "Överdådighet, isolering, brist på stöd"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A time for celebration and connection with friends and community. Embrace the joy of togetherness.",
                    reversed = "Are you feeling isolated or overindulging? It may be time to reconnect with your support system and find balance."
                ),
                "sv" to TarotInterpretation(
                    upright = "En tid för firande och koppling till vänner och gemenskap. Omfamna glädjen av samhörighet.",
                    reversed = "Känner du dig isolerad eller överdådig? Det kan vara dags att återknyta kontakten med ditt stödsystem och hitta balans."
                )
            )
        ),
        TarotCard(
            id = "four_of_cups",
            name = "Four of Cups",
            arcana = "Minor Arcana",
            imageRes = R.drawable.four_of_cups,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Apathy, contemplation, reevaluation",
                    reversed = "New opportunities, awareness, acceptance"
                ),
                "sv" to TarotMeaning(
                    upright = "Apati, kontemplation, omvärdering",
                    reversed = "Nya möjligheter, medvetenhet, acceptans"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You may be feeling apathetic or contemplative. Take time to reevaluate your emotions and desires.",
                    reversed = "Are you ready to embrace new opportunities? It may be time to open your heart and mind to acceptance."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du kanske känner dig apatisk eller kontemplativ. Ta dig tid att omvärdera dina känslor och önskningar.",
                    reversed = "Är du redo att omfamna nya möjligheter? Det kan vara dags att öppna ditt hjärta och sinne för acceptans."
                )
            )
        ),
        TarotCard(
            id = "five_of_cups",
            name = "Five of Cups",
            arcana = "Minor Arcana",
            imageRes = R.drawable.five_of_cups,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Loss, grief, disappointment",
                    reversed = "Acceptance, moving on, finding peace"
                ),
                "sv" to TarotMeaning(
                    upright = "Förlust, sorg, besvikelse",
                    reversed = "Acceptans, att gå vidare, att finna frid"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You may be experiencing loss or disappointment. Allow yourself to grieve and process your emotions.",
                    reversed = "Are you ready to move on? Embrace acceptance and find peace in the lessons learned."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du kanske upplever förlust eller besvikelse. Låt dig själv sörja och bearbeta dina känslor.",
                    reversed = "Är du redo att gå vidare? Omfamna acceptans och finn frid i de lärdomar du har fått."
                )
            )
        ),
        TarotCard(
            id = "six_of_cups",
            name = "Six of Cups",
            arcana = "Minor Arcana",
            imageRes = R.drawable.six_of_cups,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Nostalgia, childhood memories, innocence",
                    reversed = "Stuck in the past, unrealistic expectations"
                ),
                "sv" to TarotMeaning(
                    upright = "Nostalgi, barndomsminnen, oskuld",
                    reversed = "Fast i det förflutna, orealistiska förväntningar"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Embrace the joy of nostalgia and childhood memories. Innocence can bring healing.",
                    reversed = "Are you stuck in the past? It may be time to let go of unrealistic expectations and focus on the present."
                ),
                "sv" to TarotInterpretation(
                    upright = "Omfamna glädjen av nostalgi och barndomsminnen. Oskuld kan föra med sig läkning.",
                    reversed = "Sitter du fast i det förflutna? Det kan vara dags att släppa taget om orealistiska förväntningar och fokusera på nuet."
                )
            )
        ),
        TarotCard(
            id = "seven_of_cups",
            name = "Seven of Cups",
            arcana = "Minor Arcana",
            imageRes = R.drawable.seven_of_cups,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Choices, illusions, daydreams",
                    reversed = "Lack of clarity, confusion, poor choices"
                ),
                "sv" to TarotMeaning(
                    upright = "Val, illusioner, dagdrömmar",
                    reversed = "Brist på klarhet, förvirring, dåliga val"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You may be faced with many choices or illusions. Take time to gain clarity before making decisions.",
                    reversed = "Are you feeling confused or making poor choices? It may be time to reassess your options and find clarity."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du kan stå inför många val eller illusioner. Ta dig tid att få klarhet innan du fattar beslut.",
                    reversed = "Känner du dig förvirrad eller gör dåliga val? Det kan vara dags att ompröva dina alternativ och finna klarhet."
                )
            )
        ),
        TarotCard(
            id = "eight_of_cups",
            name = "Eight of Cups",
            arcana = "Minor Arcana",
            imageRes = R.drawable.eight_of_cups,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Walking away, seeking deeper meaning, introspection",
                    reversed = "Fear of change, avoidance, stagnation"
                ),
                "sv" to TarotMeaning(
                    upright = "Att gå iväg, söka djupare mening, introspektion",
                    reversed = "Rädsla för förändring, undvikande, stagnation"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "It may be time to walk away from situations that no longer serve you. Seek deeper meaning and introspection.",
                    reversed = "Are you avoiding necessary changes? It may be time to confront your fears and embrace growth."
                ),
                "sv" to TarotInterpretation(
                    upright = "Det kan vara dags att gå ifrån situationer som inte längre gynnar dig. Sök djupare mening och introspektion.",
                    reversed = "Undviker du nödvändiga förändringar? Det kan vara dags att konfrontera dina rädslor och omfamna tillväxt."
                )
            )
        ),
        TarotCard(
            id = "nine_of_cups",
            name = "Nine of Cups",
            arcana = "Minor Arcana",
            imageRes = R.drawable.nine_of_cups,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Contentment, satisfaction, emotional fulfillment",
                    reversed = "Dissatisfaction, unmet desires, overindulgence"
                ),
                "sv" to TarotMeaning(
                    upright = "Tillfredsställelse, belåtenhet, känslomässig uppfyllelse",
                    reversed = "Missnöje, ouppfyllda önskningar, överdådighet"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A time of emotional fulfillment and contentment. Celebrate your achievements and enjoy the moment.",
                    reversed = "Are you feeling dissatisfied or overindulging? It may be time to reassess your desires and find true fulfillment."
                ),
                "sv" to TarotInterpretation(
                    upright = "En tid av känslomässig uppfyllelse och belåtenhet. Fira dina prestationer och njut av ögonblicket.",
                    reversed = "Känner du dig missnöjd eller överdådig? Det kan vara dags att ompröva dina önskningar och hitta sann uppfyllelse."
                )
            )
        ),
        TarotCard(
            id = "ten_of_cups",
            name = "Ten of Cups",
            arcana = "Minor Arcana",
            imageRes = R.drawable.ten_of_cups,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Harmony, family, emotional bliss",
                    reversed = "Broken relationships, disharmony, lack of support"
                ),
                "sv" to TarotMeaning(
                    upright = "Harmoni, familj, känslomässig lycka",
                    reversed = "Brutna relationer, disharmoni, brist på stöd"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A time of harmony and emotional bliss with family and loved ones. Embrace the joy of togetherness.",
                    reversed = "Are you facing disharmony in relationships? It may be time to address issues and seek support."
                ),
                "sv" to TarotInterpretation(
                    upright = "En tid av harmoni och känslomässig lycka med familj och nära och kära. Omfamna glädjen av samhörighet.",
                    reversed = "Står du inför disharmoni i relationer? Det kan vara dags att ta itu med problemen och söka stöd."
                )
            )
        ),
        TarotCard(
            id = "page_of_cups",
            name = "Page of Cups",
            arcana = "Minor Arcana",
            imageRes = R.drawable.page_of_cups,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Creativity, intuition, new emotional experiences",
                    reversed = "Emotional immaturity, unrealistic expectations, lack of creativity"
                ),
                "sv" to TarotMeaning(
                    upright = "Kreativitet, intuition, nya känslomässiga upplevelser",
                    reversed = "Känslomässig omognad, orealistiska förväntningar, brist på kreativitet"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Embrace your creative side and explore new emotional experiences. Intuition will guide you.",
                    reversed = "Are you struggling with emotional immaturity or unrealistic expectations? It may be time to focus on self-growth."
                ),
                "sv" to TarotInterpretation(
                    upright = "Omfamna din kreativa sida och utforska nya känslomässiga upplevelser. Intuitionen kommer att vägleda dig.",
                    reversed = "Kämpar du med känslomässig omognad eller orealistiska förväntningar? Det kan vara dags att fokusera på personlig utveckling."
                )
            )
        ),
        TarotCard(
            id = "knight_of_cups",
            name = "Knight of Cups",
            arcana = "Minor Arcana",
            imageRes = R.drawable.knight_of_cups,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Romance, charm, idealism",
                    reversed = "Unrealistic expectations, moodiness, lack of direction"
                ),
                "sv" to TarotMeaning(
                    upright = "Romantik, charm, idealism",
                    reversed = "Orealistiska förväntningar, lynnighet, brist på riktning"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A romantic or charming energy is present. Embrace your idealism but stay grounded.",
                    reversed = "Are you struggling with unrealistic expectations or moodiness? It may be time to find a clearer path forward."
                ),
                "sv" to TarotInterpretation(
                    upright = "En romantisk eller charmig energi är närvarande. Omfamna din idealism men håll fötterna på jorden.",
                    reversed = "Kämpar du med orealistiska förväntningar eller lynnighet? Det kan vara dags att hitta en tydligare väg framåt i dina känslor."
                )
            )
        ),
        TarotCard(
            id = "queen_of_cups",
            name = "Queen of Cups",
            arcana = "Minor Arcana",
            imageRes = R.drawable.queen_of_cups,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Compassion, empathy, emotional intelligence",
                    reversed = "Emotional insecurity, lack of self-care, overemotional"
                ),
                "sv" to TarotMeaning(
                    upright = "Medkänsla, empati, känslomässig intelligens",
                    reversed = "Känslomässig osäkerhet, brist på självvård, överkänslighet"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Embrace your compassion and empathy. Your emotional intelligence will guide you in relationships.",
                    reversed = "Are you struggling with emotional insecurity or neglecting self-care? It may be time to focus on nurturing yourself."
                ),
                "sv" to TarotInterpretation(
                    upright = "Omfamna din medkänsla och empati. Din känslomässiga intelligens kommer att vägleda dig i relationer.",
                    reversed = "Kämpar du med känslomässig osäkerhet eller försummar du att ta hand om dig själv? Det kan vara dags att fokusera på att vårda dig själv."
                )
            )
        ),
        TarotCard(
            id = "king_of_cups",
            name = "King of Cups",
            arcana = "Minor Arcana",
            imageRes = R.drawable.king_of_cups,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Emotional balance, diplomacy, wisdom",
                    reversed = "Emotional manipulation, moodiness, lack of control"
                ),
                "sv" to TarotMeaning(
                    upright = "Känslomässig balans, diplomati, visdom",
                    reversed = "Känslomässig manipulation, lynnighet, brist på kontroll"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You possess emotional balance and wisdom. Use your diplomacy to navigate relationships.",
                    reversed = "Are you struggling with emotional manipulation or moodiness? It may be time to regain control over your emotions."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du besitter känslomässig balans och visdom. Använd din diplomati för att navigera i relationer.",
                    reversed = "Kämpar du med känslomässig manipulation eller lynnighet? Det kan vara dags att återta kontrollen över dina känslor."
                )
            )
        ),
        TarotCard(
            id = "ace_of_swords",
            name = "Ace of Swords",
            arcana = "Minor Arcana",
            imageRes = R.drawable.ace_of_swords,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Clarity, truth, new ideas",
                    reversed = "Confusion, lack of clarity, dishonesty"
                ),
                "sv" to TarotMeaning(
                    upright = "Klarhet, sanning, nya idéer",
                    reversed = "Förvirring, brist på klarhet, oärlighet"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A new idea or clarity is emerging. Embrace the truth and communicate openly.",
                    reversed = "Are you facing confusion or lack of clarity? It may be time to seek clarity and confront the truth."
                ),
                "sv" to TarotInterpretation(
                    upright = "En ny idé eller klarhet är på väg att framträda. Omfamna sanningen och kommunicera öppet.",
                    reversed = "Står du inför förvirring eller brist på klarhet? Det kan vara dags att söka klarhet och konfrontera sanningen."
                )
            )
        ),
        TarotCard(
            id = "two_of_swords",
            name = "Two of Swords",
            arcana = "Minor Arcana",
            imageRes = R.drawable.two_of_swords,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Indecision, stalemate, difficult choices",
                    reversed = "Clarity, resolution, overcoming obstacles"
                ),
                "sv" to TarotMeaning(
                    upright = "Obeslutsamhet, dödläge, svåra val",
                    reversed = "Klarhet, lösning, att övervinna hinder"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You may be facing a difficult decision or stalemate. Take time to gain clarity before making a choice.",
                    reversed = "Are you ready to overcome obstacles and find resolution? Embrace clarity and move forward with confidence."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du kan stå inför ett svårt beslut eller dödläge. Ta dig tid att få klarhet innan du gör ett val.",
                    reversed = "Är du redo att övervinna hinder och finna en lösning? Omfamna klarhet och gå vidare med självförtroende."
                )
            )
        ),
        TarotCard(
            id = "three_of_swords",
            name = "Three of Swords",
            arcana = "Minor Arcana",
            imageRes = R.drawable.three_of_swords,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Heartbreak, sorrow, emotional pain",
                    reversed = "Healing, forgiveness, moving on"
                ),
                "sv" to TarotMeaning(
                    upright = "Hjärtesorg, sorg, emotionell smärta",
                    reversed = "Läkning, förlåtelse, att gå vidare"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You may be experiencing heartbreak or emotional pain. Allow yourself to grieve and heal.",
                    reversed = "Are you ready to forgive and move on? Embrace the healing process and find peace."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du kan uppleva hjärtesorg eller emotionell smärta. Låt dig själv sörja och läka.",
                    reversed = "Är du redo att förlåta och gå vidare? Omfamna läkningsprocessen och finn frid."
                )
            )
        ),
        TarotCard(
            id = "four_of_swords",
            name = "Four of Swords",
            arcana = "Minor Arcana",
            imageRes = R.drawable.four_of_swords,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Rest, recovery, contemplation",
                    reversed = "Burnout, stress, lack of rest"
                ),
                "sv" to TarotMeaning(
                    upright = "Vila, återhämtning, kontemplation",
                    reversed = "Utbrändhet, stress, brist på vila"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Take time for rest and recovery. Contemplate your next steps with a clear mind.",
                    reversed = "Are you feeling burnt out or stressed? It may be time to prioritize self-care and rest."
                ),
                "sv" to TarotInterpretation(
                    upright = "Ta dig tid för vila och återhämtning. Kontemplera dina nästa steg med ett klart sinne.",
                    reversed = "Känner du dig utbränd eller stressad? Det kan vara dags att prioritera självvård och vila."
                )
            )
        ),
        TarotCard(
            id = "five_of_swords",
            name = "Five of Swords",
            arcana = "Minor Arcana",
            imageRes = R.drawable.five_of_swords,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Conflict, tension, betrayal",
                    reversed = "Resolution, compromise, moving on from conflict"
                ),
                "sv" to TarotMeaning(
                    upright = "Konflikt, spänning, svek",
                    reversed = "Lösning, kompromiss, att gå vidare från konflikt"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You may be facing conflict or tension. Consider finding a resolution through compromise.",
                    reversed = "Are you ready to move on from conflict? Embrace resolution and let go of past grievances."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du kan stå inför konflikt eller spänning. Överväg att finna en lösning genom kompromiss.",
                    reversed = "Är du redo att gå vidare från konflikt? Omfamna lösning och släpp taget om gamla agg."
                )
            )
        ),
        TarotCard(
            id = "six_of_swords",
            name = "Six of Swords",
            arcana = "Minor Arcana",
            imageRes = R.drawable.six_of_swords,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Transition, moving on, travel",
                    reversed = "Stagnation, resistance to change, unresolved issues"
                ),
                "sv" to TarotMeaning(
                    upright = "Övergång, att gå vidare, resor",
                    reversed = "Stagnation, motstånd mot förändring, olösta problem"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A transition or journey is on the horizon. Embrace the opportunity to move on and find new horizons.",
                    reversed = "Are you resisting necessary changes? It may be time to confront unresolved issues and embrace growth."
                ),
                "sv" to TarotInterpretation(
                    upright = "En övergång eller resa är i sikte. Omfamna möjligheten att gå vidare och hitta nya horisonter.",
                    reversed = "Gör du motstånd mot nödvändiga förändringar? Det kan vara dags att konfrontera olösta problem och omfamna tillväxt."
                )
            )
        ),
        TarotCard(
            id = "seven_of_swords",
            name = "Seven of Swords",
            arcana = "Minor Arcana",
            imageRes = R.drawable.seven_of_swords,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Deception, strategy, stealth",
                    reversed = "Truth, honesty, coming clean"
                ),
                "sv" to TarotMeaning(
                    upright = "Bedrägeri, strategi, smygande",
                    reversed = "Sanning, ärlighet, att bekänna"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Be cautious of deception or dishonesty. Use strategy wisely but avoid unethical actions.",
                    reversed = "Are you ready to embrace the truth? It may be time to come clean and face the consequences."
                ),
                "sv" to TarotInterpretation(
                    upright = "Var försiktig med bedrägeri eller oärlighet. Använd strategi klokt men undvik oetiska handlingar.",
                    reversed = "Är du redo att omfamna sanningen? Det kan vara dags att bekänna och möta konsekvenserna."
                )
            )
        ),
        TarotCard(
            id = "eight_of_swords",
            name = "Eight of Swords",
            arcana = "Minor Arcana",
            imageRes = R.drawable.eight_of_swords,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Restriction, limitation, feeling trapped",
                    reversed = "Freedom, release from restrictions, new perspectives"
                ),
                "sv" to TarotMeaning(
                    upright = "Begränsning, inskränkning, att känna sig fångad",
                    reversed = "Frihet, frigörelse från begränsningar, nya perspektiv"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You may be feeling restricted or trapped. Take time to reassess your situation and find a way out.",
                    reversed = "Are you ready to break free from limitations? Embrace new perspectives and find your freedom."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du kanske känner dig begränsad eller fångad. Ta dig tid att omvärdera din situation och hitta en väg ut.",
                    reversed = "Är du redo att bryta dig loss från begränsningar? Omfamna nya perspektiv och finn din frihet."
                )
            )
        ),
        TarotCard(
            id = "nine_of_swords",
            name = "Nine of Swords",
            arcana = "Minor Arcana",
            imageRes = R.drawable.nine_of_swords,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Anxiety, fear, nightmares",
                    reversed = "Release from anxiety, finding peace of mind"
                ),
                "sv" to TarotMeaning(
                    upright = "Ångest, rädsla, mardrömmar",
                    reversed = "Frigörelse från ångest, att finna sinnesfrid"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You may be experiencing anxiety or fear. Take time to confront your worries and find peace of mind.",
                    reversed = "Are you ready to release anxiety? Embrace the opportunity to find peace and clarity."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du kan uppleva ångest eller rädsla. Ta dig tid att konfrontera dina bekymmer och finna sinnesfrid.",
                    reversed = "Är du redo att släppa ångesten? Omfamna möjligheten att finna frid och klarhet."
                )
            )
        ),
        TarotCard(
            id = "ten_of_swords",
            name = "Ten of Swords",
            arcana = "Minor Arcana",
            imageRes = R.drawable.ten_of_swords,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Betrayal, loss, painful endings",
                    reversed = "Recovery, regeneration, new beginnings"
                ),
                "sv" to TarotMeaning(
                    upright = "Svek, förlust, smärtsamma slut",
                    reversed = "Återhämtning, förnyelse, nya början"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You may be facing a painful ending or betrayal. Allow yourself to grieve and heal.",
                    reversed = "Are you ready for recovery and new beginnings? Embrace the opportunity to regenerate and move forward."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du kan stå inför ett smärtsamt slut eller svek. Låt dig själv sörja och läka.",
                    reversed = "Är du redo för återhämtning och nya början? Omfamna möjligheten att förnyas och gå vidare."
                )
            )
        ),
        TarotCard(
            id = "page_of_swords",
            name = "Page of Swords",
            arcana = "Minor Arcana",
            imageRes = R.drawable.page_of_swords,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Curiosity, intellect, new ideas",
                    reversed = "Deception, manipulation, lack of clarity"
                ),
                "sv" to TarotMeaning(
                    upright = "Nyfikenhet, intellekt, nya idéer",
                    reversed = "Bedrägeri, manipulation, brist på klarhet"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Embrace your curiosity and intellect. New ideas are on the horizon.",
                    reversed = "Are you facing deception or lack of clarity? It may be time to seek the truth and confront manipulation."
                ),
                "sv" to TarotInterpretation(
                    upright = "Omfamna din nyfikenhet och ditt intellekt. Nya idéer är i sikte.",
                    reversed = "Står du inför bedrägeri eller brist på klarhet? Det kan vara dags att söka sanningen och konfrontera manipulation."
                )
            )
        ),
        TarotCard(
            id = "knight_of_swords",
            name = "Knight of Swords",
            arcana = "Minor Arcana",
            imageRes = R.drawable.knight_of_swords,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Action, ambition, assertiveness",
                    reversed = "Haste, recklessness, lack of direction"
                ),
                "sv" to TarotMeaning(
                    upright = "Handling, ambition, självsäkerhet",
                    reversed = "Hastighet, vårdslöshet, brist på riktning"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Take decisive action and embrace your ambitions. Assertiveness will lead to success.",
                    reversed = "Are you being reckless or lacking direction? It may be time to find a clearer path forward."
                ),
                "sv" to TarotInterpretation(
                    upright = "Agera beslutsamt och omfamna dina ambitioner. Självsäkerhet leder till framgång.",
                    reversed = "Är du vårdslös eller saknar riktning? Det kan vara dags att hitta en tydligare väg framåt."
                )
            )
        ),
        TarotCard(
            id = "queen_of_swords",
            name = "Queen of Swords",
            arcana = "Minor Arcana",
            imageRes = R.drawable.queen_of_swords,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Independence, perception, clear communication",
                    reversed = "Coldness, bitterness, lack of empathy"
                ),
                "sv" to TarotMeaning(
                    upright = "Oberoende, perception, tydlig kommunikation",
                    reversed = "Kyla, bitterhet, brist på empati"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Embrace your independence and clear communication. Your perception will guide you in relationships.",
                    reversed = "Are you struggling with coldness or bitterness? It may be time to focus on empathy and understanding."
                ),
                "sv" to TarotInterpretation(
                    upright = "Omfamna ditt oberoende och din tydliga kommunikation. Din perception kommer att vägleda dig i relationer.",
                    reversed = "Kämpar du med kyla eller bitterhet? Det kan vara dags att fokusera på empati och förståelse."
                )
            )
        ),
        TarotCard(
            id = "king_of_swords",
            name = "King of Swords",
            arcana = "Minor Arcana",
            imageRes = R.drawable.king_of_swords,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Intellect, authority, truth",
                    reversed = "Manipulation, tyranny, lack of clarity"
                ),
                "sv" to TarotMeaning(
                    upright = "Intellekt, auktoritet, sanning",
                    reversed = "Manipulation, tyranni, brist på klarhet"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You possess intellect and authority. Use your truth to guide others.",
                    reversed = "Are you struggling with manipulation or lack of clarity? It may be time to regain control over your thoughts and actions."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du besitter intellekt och auktoritet. Använd din sanning för att vägleda andra.",
                    reversed = "Kämpar du med manipulation eller brist på klarhet? Det kan vara dags att återta kontrollen över dina tankar och handlingar."
                )
            )
        ),
        TarotCard(
            id = "ace_of_pentacles",
            name = "Ace of Pentacles",
            arcana = "Minor Arcana",
            imageRes = R.drawable.ace_of_pentacles,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "New financial opportunities, prosperity, stability",
                    reversed = "Missed opportunities, lack of resources, financial instability"
                ),
                "sv" to TarotMeaning(
                    upright = "Nya ekonomiska möjligheter, välstånd, stabilitet",
                    reversed = "Missade möjligheter, brist på resurser, ekonomisk instabilitet"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A new financial opportunity or stable foundation is on the horizon. Embrace prosperity and stability.",
                    reversed = "Are you facing missed opportunities or financial instability? It may be time to reassess your resources and find new paths to prosperity."
                ),
                "sv" to TarotInterpretation(
                    upright = "En ny ekonomisk möjlighet eller stabil grund är i sikte. Omfamna välstånd och stabilitet.",
                    reversed = "Står du inför missade möjligheter eller ekonomisk instabilitet? Det kan vara dags att ompröva dina resurser och hitta nya vägar till välstånd."
                )
            )
        ),
        TarotCard(
            id = "two_of_pentacles",
            name = "Two of Pentacles",
            arcana = "Minor Arcana",
            imageRes = R.drawable.two_of_pentacles,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Balance, adaptability, time management",
                    reversed = "Overwhelm, disorganization, lack of balance"
                ),
                "sv" to TarotMeaning(
                    upright = "Balans, anpassningsförmåga, tidshantering",
                    reversed = "Överväldigande, oordning, brist på balans"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You are managing multiple responsibilities with grace. Embrace balance and adaptability.",
                    reversed = "Are you feeling overwhelmed or disorganized? It may be time to reassess your priorities and find balance."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du hanterar flera ansvarsområden med elegans. Omfamna balans och anpassningsförmåga.",
                    reversed = "Känner du dig överväldigad eller oorganiserad? Det kan vara dags att ompröva dina prioriteringar och hitta balans."
                )
            )
        ),
        TarotCard(
            id = "three_of_pentacles",
            name = "Three of Pentacles",
            arcana = "Minor Arcana",
            imageRes = R.drawable.three_of_pentacles,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Collaboration, teamwork, skill development",
                    reversed = "Lack of teamwork, poor planning, miscommunication"
                ),
                "sv" to TarotMeaning(
                    upright = "Samarbete, lagarbete, kompetensutveckling",
                    reversed = "Brist på lagarbete, dålig planering, missförstånd"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Collaboration and teamwork will lead to success. Embrace skill development and shared goals.",
                    reversed = "Are you facing miscommunication or poor planning? It may be time to reassess your team dynamics and find common ground."
                ),
                "sv" to TarotInterpretation(
                    upright = "Samarbete och lagarbete leder till framgång. Omfamna kompetensutveckling och delade mål.",
                    reversed = "Står du inför missförstånd eller dålig planering? Det kan vara dags att ompröva din teamdynamik och hitta gemensamma nämnare."
                )
            )
        ),
        TarotCard(
            id = "four_of_pentacles",
            name = "Four of Pentacles",
            arcana = "Minor Arcana",
            imageRes = R.drawable.four_of_pentacles,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Control, stability, holding on to resources",
                    reversed = "Greed, materialism, fear of loss"
                ),
                "sv" to TarotMeaning(
                    upright = "Kontroll, stabilitet, att hålla fast vid resurser",
                    reversed = "Girighet, materialism, rädsla för förlust"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You may be holding on tightly to your resources. Consider finding a balance between control and generosity.",
                    reversed = "Are you struggling with greed or fear of loss? It may be time to let go and embrace abundance."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du kanske håller fast hårt vid dina resurser. Överväg att hitta en balans mellan kontroll och generositet.",
                    reversed = "Kämpar du med girighet eller rädsla för förlust? Det kan vara dags att släppa taget och omfamna överflöd."
                )
            )
        ),
        TarotCard(
            id = "five_of_pentacles",
            name = "Five of Pentacles",
            arcana = "Minor Arcana",
            imageRes = R.drawable.five_of_pentacles,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Financial loss, hardship, isolation",
                    reversed = "Recovery, improvement, finding support"
                ),
                "sv" to TarotMeaning(
                    upright = "Ekonomisk förlust, svårigheter, isolering",
                    reversed = "Återhämtning, förbättring, att finna stöd"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You may be facing financial loss or hardship. Seek support and focus on recovery.",
                    reversed = "Are you ready to improve your situation? Embrace recovery and find the support you need."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du kan stå inför ekonomisk förlust eller svårigheter. Sök stöd och fokusera på återhämtning.",
                    reversed = "Är du redo att förbättra din situation? Omfamna återhämtning och finn det stöd du behöver."
                )
            )
        ),
        TarotCard(
            id = "six_of_pentacles",
            name = "Six of Pentacles",
            arcana = "Minor Arcana",
            imageRes = R.drawable.six_of_pentacles,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Generosity, sharing, balance in giving and receiving",
                    reversed = "Inequality, selfishness, lack of generosity"
                ),
                "sv" to TarotMeaning(
                    upright = "Generositet, delning, balans i att ge och ta emot",
                    reversed = "Ojämlikhet, egoism, brist på generositet"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A time for generosity and sharing. Find balance in giving and receiving.",
                    reversed = "Are you struggling with inequality or selfishness? It may be time to reassess your approach to generosity."
                ),
                "sv" to TarotInterpretation(
                    upright = "En tid för generositet och delning. Hitta balans i att ge och ta emot.",
                    reversed = "Kämpar du med ojämlikhet eller egoism? Det kan vara dags att ompröva ditt tillvägagångssätt för generositet."
                )
            )
        ),
        TarotCard(
            id = "seven_of_pentacles",
            name = "Seven of Pentacles",
            arcana = "Minor Arcana",
            imageRes = R.drawable.seven_of_pentacles,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Patience, long-term success, assessment of progress",
                    reversed = "Lack of progress, impatience, poor planning"
                ),
                "sv" to TarotMeaning(
                    upright = "Tålamod, långsiktig framgång, bedömning av framsteg",
                    reversed = "Brist på framsteg, otålighet, dålig planering"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Take time to assess your progress and be patient. Long-term success is on the horizon.",
                    reversed = "Are you feeling impatient or facing a lack of progress? It may be time to reassess your plans and find new strategies."
                ),
                "sv" to TarotInterpretation(
                    upright = "Ta dig tid att bedöma dina framsteg och ha tålamod. Långsiktig framgång är i sikte.",
                    reversed = "Känner du dig otålig eller står inför brist på framsteg? Det kan vara dags att ompröva dina planer och hitta nya strategier."
                )
            )
        ),
        TarotCard(
            id = "eight_of_pentacles",
            name = "Eight of Pentacles",
            arcana = "Minor Arcana",
            imageRes = R.drawable.eight_of_pentacles,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Skill development, hard work, dedication",
                    reversed = "Lack of focus, poor quality work, burnout"
                ),
                "sv" to TarotMeaning(
                    upright = "Kompetensutveckling, hårt arbete, engagemang",
                    reversed = "Brist på fokus, arbete av dålig kvalitet, utbrändhet"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Dedication to skill development will lead to success. Embrace hard work and focus.",
                    reversed = "Are you feeling burnt out or lacking focus? It may be time to reassess your work-life balance."
                ),
                "sv" to TarotInterpretation(
                    upright = "Engagemang för kompetensutveckling leder till framgång. Omfamna hårt arbete och fokus.",
                    reversed = "Känner du dig utbränd eller saknar fokus? Det kan vara dags att ompröva din balans mellan arbete och fritid."
                )
            )
        ),
        TarotCard(
            id = "nine_of_pentacles",
            name = "Nine of Pentacles",
            arcana = "Minor Arcana",
            imageRes = R.drawable.nine_of_pentacles,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Financial independence, luxury, self-sufficiency",
                    reversed = "Financial setbacks, lack of self-sufficiency, dependence on others"
                ),
                "sv" to TarotMeaning(
                    upright = "Ekonomiskt oberoende, lyx, självförsörjning",
                    reversed = "Ekonomiska motgångar, brist på självförsörjning, beroende av andra"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A time of financial independence and luxury. Embrace self-sufficiency and enjoy the fruits of your labor.",
                    reversed = "Are you facing financial setbacks or dependence on others? It may be time to reassess your financial strategies and find independence."
                ),
                "sv" to TarotInterpretation(
                    upright = "En tid av ekonomiskt oberoende och lyx. Omfamna självförsörjning och njut av frukterna av ditt arbete.",
                    reversed = "Står du inför ekonomiska motgångar eller beroende av andra? Det kan vara dags att ompröva dina ekonomiska strategier och hitta oberoende."
                )
            )
        ),
        TarotCard(
            id = "ten_of_pentacles",
            name = "Ten of Pentacles",
            arcana = "Minor Arcana",
            imageRes = R.drawable.ten_of_pentacles,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Legacy, family, long-term success",
                    reversed = "Lack of stability, family conflicts, short-term focus"
                ),
                "sv" to TarotMeaning(
                    upright = "Arv, familj, långsiktig framgång",
                    reversed = "Brist på stabilitet, familjekonflikter, kortsiktigt fokus"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "A time for building a legacy and enjoying family connections. Long-term success is within reach.",
                    reversed = "Are you facing family conflicts or lack of stability? It may be time to focus on long-term goals and find harmony."
                ),
                "sv" to TarotInterpretation(
                    upright = "En tid för att bygga ett arv och njuta av familjeband. Långsiktig framgång är inom räckhåll.",
                    reversed = "Står du inför familjekonflikter eller brist på stabilitet? Det kan vara dags att fokusera på långsiktiga mål och hitta harmoni."
                )
            )
        ),
        TarotCard(
            id = "page_of_pentacles",
            name = "Page of Pentacles",
            arcana = "Minor Arcana",
            imageRes = R.drawable.page_of_pentacles,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "New financial opportunities, ambition, practicality",
                    reversed = "Lack of ambition, missed opportunities, poor planning"
                ),
                "sv" to TarotMeaning(
                    upright = "Nya ekonomiska möjligheter, ambition, praktiskhet",
                    reversed = "Brist på ambition, missade möjligheter, dålig planering"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Embrace new financial opportunities with ambition and practicality. Your efforts will lead to success.",
                    reversed = "Are you missing out on opportunities or lacking ambition? It may be time to reassess your financial strategies and plans."
                ),
                "sv" to TarotInterpretation(
                    upright = "Omfamna nya ekonomiska möjligheter med ambition och praktiskhet. Dina ansträngningar leder till framgång.",
                    reversed = "Missar du möjligheter eller saknar ambition? Det kan vara dags att ompröva dina ekonomiska strategier och planer."
                )
            )
        ),
        TarotCard(
            id = "knight_of_pentacles",
            name = "Knight of Pentacles",
            arcana = "Minor Arcana",
            imageRes = R.drawable.knight_of_pentacles,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Hard work, reliability, practicality",
                    reversed = "Stagnation, lack of progress, laziness"
                ),
                "sv" to TarotMeaning(
                    upright = "Hårt arbete, pålitlighet, praktiskhet",
                    reversed = "Stagnation, brist på framsteg, lathet"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Dedication to hard work and reliability will lead to success. Embrace practicality in your endeavors.",
                    reversed = "Are you feeling stagnant or lazy? It may be time to find new motivation and take action towards your goals."
                ),
                "sv" to TarotInterpretation(
                    upright = "Engagemang för hårt arbete och pålitlighet leder till framgång. Omfamna praktiskhet i dina ansträngningar.",
                    reversed = "Känner du dig stillastående eller lat? Det kan vara dags att hitta ny motivation och agera mot dina mål."
                )
            )
        ),
        TarotCard(
            id = "queen_of_pentacles",
            name = "Queen of Pentacles",
            arcana = "Minor Arcana",
            imageRes = R.drawable.queen_of_pentacles,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Nurturing, practicality, financial security",
                    reversed = "Neglecting responsibilities, financial instability, lack of nurturing"
                ),
                "sv" to TarotMeaning(
                    upright = "Omvårdnad, praktiskhet, ekonomisk trygghet",
                    reversed = "Försummande av ansvar, ekonomisk instabilitet, brist på omvårdnad"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "Embrace your nurturing side and focus on practicality. Financial security is within reach.",
                    reversed = "Are you neglecting responsibilities or facing financial instability? It may be time to reassess your priorities and find balance."
                ),
                "sv" to TarotInterpretation(
                    upright = "Omfamna din vårdande sida och fokusera på praktiskhet. Ekonomisk trygghet är inom räckhåll.",
                    reversed = "Försummar du ansvar eller står inför ekonomisk instabilitet? Det kan vara dags att ompröva dina prioriteringar och hitta balans."
                )
            )
        ),
        TarotCard(
            id = "king_of_pentacles",
            name = "King of Pentacles",
            arcana = "Minor Arcana",
            imageRes = R.drawable.king_of_pentacles,
            meaning = mapOf(
                "en" to TarotMeaning(
                    upright = "Wealth, stability, leadership",
                    reversed = "Greed, materialism, lack of stability"
                ),
                "sv" to TarotMeaning(
                    upright = "Rikedom, stabilitet, ledarskap",
                    reversed = "Girighet, materialism, brist på stabilitet"
                )
            ),
            interpretation = mapOf(
                "en" to TarotInterpretation(
                    upright = "You possess the qualities of a strong leader. Embrace wealth and stability with humility.",
                    reversed = "Are you struggling with greed or materialism? It may be time to focus on stability and responsible leadership."
                ),
                "sv" to TarotInterpretation(
                    upright = "Du besitter egenskaperna hos en stark ledare. Omfamna rikedom och stabilitet med ödmjukhet.",
                    reversed = "Kämpar du med girighet eller materialism? Det kan vara dags att fokusera på stabilitet och ansvarsfullt ledarskap."
                )
            )
        )
    )
}







