// data/tarotCards.js

export const tarotCards = [
  {
    id: 'the_fool',
    name: 'The Fool',
    arcana: 'Major Arcana',
    image: require('../assets/tarot/the_fool.png'), // Se till att sökvägen till bilden stämmer!
    meaning: {
      upright: 'New beginnings, innocence, free spirit',
      reversed: 'Recklessness, risk-taking, naiveté',
    },
    interpretation: {
      upright: 'A journey awaits, full of unknown possibilities and fresh starts. Embrace the adventure with an open heart.',
      reversed: 'Beware of impulsive decisions or a lack of foresight. Ground yourself before taking the leap.',
    },
  },
  {
    id: 'the_magician',
    name: 'The Magician',
    arcana: 'Major Arcana',
    image: require('../assets/tarot/the_magician.png'),
    meaning: {
      upright: 'Manifestation, resourcefulness, power',
      reversed: 'Manipulation, poor planning, untapped talents',
    },
    interpretation: {
      upright: 'You have all the tools and skills needed to manifest your desires. Focus your will and take action.',
      reversed: 'Are you using your abilities wisely? Or are you being deceptive or unfocused?',
    },
  },
  {
    id: 'the_high_priestess',
    name: 'The High Priestess',
    arcana: 'Major Arcana',
    image: require('../assets/tarot/the_high_priestess.png'),
    meaning: {
      upright: 'Intuition, subconscious, mystery',
      reversed: 'Hidden agendas, secrets, repressed intuition',
    },
    interpretation: {
      upright: 'Listen to your inner voice and trust your intuition. There are hidden truths waiting to be revealed.',
      reversed: 'Something is being concealed, or you are ignoring your inner wisdom.',
    },
  },
  {
    id: 'the_empress',
    name: 'The Empress',
    arcana: 'Major Arcana',
    image: require('../assets/tarot/the_empress.png'),
    meaning: {
      upright: 'Femininity, beauty, nature, abundance, fertility',
      reversed: 'Dependence, stagnation, barrenness',
    },
    interpretation: {
      upright: 'A period of growth, creativity, and nurturing. Connect with nature and embrace your sensual side.',
      reversed: 'Feeling stuck or creatively blocked? Perhaps an unhealthy dependence is present.',
    },
  },
  {
    id: 'the_emperor',
    name: 'The Emperor',
    arcana: 'Major Arcana',
    image: require('../assets/tarot/the_emperor.png'),
    meaning: {
      upright: 'Authority, structure, control, father figure',
      reversed: 'Domination, rigidity, immaturity',
    },
    interpretation: {
      upright: 'Take charge and establish order. You have the power to create stability and security.',
      reversed: 'Are you being too controlling or inflexible? Or are you struggling with a lack of discipline?',
    },
  },
    {
        id: 'the_hierophant',
        name: 'The Hierophant',
        arcana: 'Major Arcana',
        image: require('../assets/tarot/the_hierophant.png'),
        meaning: {
        upright: 'Tradition, conformity, morality, spiritual guidance',
        reversed: 'Rebellion, subversiveness, new approaches',
        },
        interpretation: {
        upright: 'Seek wisdom from established institutions or mentors. Embrace tradition but remain open to new ideas.',
        reversed: 'Challenge the status quo. It may be time to break free from outdated beliefs.',
        },
    },
    {
        id: 'the_lovers',
        name: 'The Lovers',
        arcana: 'Major Arcana',
        image: require('../assets/tarot/the_lovers.png'),
        meaning: {
        upright: 'Love, harmony, relationships, choices',
        reversed: 'Disharmony, imbalance, miscommunication',
        },
        interpretation: {
        upright: 'A deep connection with another person or a choice that needs to be made with love and care.',
        reversed: 'Conflict in relationships or a difficult choice that may lead to disharmony.',
        },
    },
    {
        id: 'the_chariot',
        name: 'The Chariot',
        arcana: 'Major Arcana',
        image: require('../assets/tarot/the_chariot.png'),
        meaning: {
        upright: 'Determination, willpower, control, victory',
        reversed: 'Lack of control, aggression, obstacles',
        },
        interpretation: {
        upright: 'Harness your willpower to overcome challenges. Success is within reach if you stay focused.',
        reversed: 'Are you losing control? Obstacles may be blocking your path; reassess your approach.',
        },
    },
    {
        id: 'strength',
        name: 'Strength',
        arcana: 'Major Arcana',
        image: require('../assets/tarot/strength.png'),
        meaning: {
        upright: 'Courage, bravery, compassion, inner strength',
        reversed: 'Self-doubt, weakness, insecurity',
        },
        interpretation: {
        upright: 'You possess the inner strength to face any challenge. Approach situations with compassion and courage.',
        reversed: 'Are you doubting your abilities? It may be time to build your confidence and face your fears.',
        },
    },
    {
        id: 'the_hermit',
        name: 'The Hermit',
        arcana: 'Major Arcana',
        image: require('../assets/tarot/the_hermit.png'),
        meaning: {
        upright: 'Introspection, solitude, inner guidance',
        reversed: 'Isolation, loneliness, withdrawal',
        },
        interpretation: {
        upright: 'Take time for self-reflection and seek inner wisdom. Solitude can lead to profound insights.',
        reversed: 'Are you isolating yourself too much? It may be time to reconnect with others.',
        },
    },
    {
        id: 'wheel_of_fortune',
        name: 'Wheel of Fortune',
        arcana: 'Major Arcana',
        image: require('../assets/tarot/wheel_of_fortune.png'),
        meaning: {
        upright: 'Change, cycles, fate, destiny',
        reversed: 'Bad luck, resistance to change, setbacks',
        },
        interpretation: {
        upright: 'Embrace the cycles of life. Change is inevitable, and it can bring new opportunities.',
        reversed: 'Feeling stuck or facing setbacks? It may be time to reassess your path and adapt.',
        },
    },
    {
        id: 'justice',
        name: 'Justice',
        arcana: 'Major Arcana',
        image: require('../assets/tarot/justice.png'),
        meaning: {
        upright: 'Fairness, truth, law, cause and effect',
        reversed: 'Dishonesty, unfairness, imbalance',
        },
        interpretation: {
        upright: 'Seek fairness and truth in your dealings. Justice will prevail.',
        reversed: 'Are you facing dishonesty or unfair treatment? It may be time to address imbalances in your life.',
        },
    },
    {
        id: 'the_hanged',
        name: 'The Hanged',
        arcana: 'Major Arcana',
        image: require('../assets/tarot/the_hanged.png'),
        meaning: {
        upright: 'Sacrifice, letting go, new perspectives',
        reversed: 'Stalling, indecision, resistance to change',
        },
        interpretation: {
        upright: 'Sometimes you must let go to gain a new perspective. Embrace the pause and reflect.',
        reversed: 'Are you resisting necessary changes? It may be time to make a decision and move forward.',
        },
    },
    {
        id: 'death',
        name: 'Death',
        arcana: 'Major Arcana',
        image: require('../assets/tarot/death.png'),
        meaning: {
        upright: 'Transformation, endings, new beginnings',
        reversed: 'Fear of change, stagnation, resistance',
        },
        interpretation: {
        upright: 'Embrace transformation and let go of the old to make way for the new. Endings can lead to new beginnings.',
        reversed: 'Are you resisting necessary changes? It may be time to confront your fears and embrace transformation.',
        },
    },
    {
        id: 'temperance',
        name: 'Temperance',
        arcana: 'Major Arcana',
        image: require('../assets/tarot/temperance.png'),
        meaning: {
        upright: 'Balance, moderation, harmony, patience',
        reversed: 'Imbalance, excess, lack of long-term vision',
        },
        interpretation: {
        upright: 'Seek balance in all aspects of your life. Patience and moderation will lead to harmony.',
        reversed: 'Are you overindulging or lacking balance? It may be time to reassess your priorities.',
        },
    },
    {
        id: 'the_devil',
        name: 'The Devil',
        arcana: 'Major Arcana',
        image: require('../assets/tarot/the_devil.png'),
        meaning: {
        upright: 'Addiction, materialism, playfulness, temptation',
        reversed: 'Freedom, release, restoring control',
        },
        interpretation: {
        upright: 'Beware of temptations and material attachments. Are you feeling trapped by your desires?',
        reversed: 'You have the power to break free from unhealthy attachments and regain control of your life.',
        },
    },
    {
      id: 'the_tower',
      name: 'The Tower',
      arcana: 'Major Arcana',
      image: require('../assets/tarot/the_tower.png'),
      meaning: {
          upright: 'Sudden upheaval, chaos, revelation',
          reversed: 'Avoidance of disaster, fear of change',
      },
      interpretation: {
          upright: 'Prepare for a sudden change or revelation that may shake your foundations. Embrace the chaos for growth.',
          reversed: 'Are you avoiding necessary changes? It may be time to confront the truth and rebuild.',
      },
    },
    {
        id: 'the_star',
        name: 'The Star',
        arcana: 'Major Arcana',
        image: require('../assets/tarot/the_star.png'),
        meaning: {
            upright: 'Hope, inspiration, serenity, renewal',
            reversed: 'Lack of faith, despair, discouragement',
        },
        interpretation: {
            upright: 'A time of healing and renewal. Trust in the universe and have faith in your path.',
            reversed: 'Feeling lost or discouraged? It may be time to reconnect with your inner light.',
        },
        },
        {
        id: 'the_moon',
        name: 'The Moon',
        arcana: 'Major Arcana',
        image: require('../assets/tarot/the_moon.png'),
        meaning: {
            upright: 'Illusion, intuition, subconscious, dreams',
            reversed: 'Deception, confusion, fear',
        },
        interpretation: {
            upright: 'Trust your intuition and explore the depths of your subconscious. Beware of illusions.',
            reversed: 'Are you facing confusion or deception? It may be time to confront your fears and seek clarity.',
        },
        },
        {
        id: 'the_sun',
        name: 'The Sun',
        arcana: 'Major Arcana',
        image: require('../assets/tarot/the_sun.png'),
        meaning: {
            upright: 'Joy, success, positivity, vitality',
            reversed: 'Temporary depression, lack of success',
        },
        interpretation: {
            upright: 'A time of joy and success. Embrace positivity and let your inner light shine.',
            reversed: 'Feeling down or facing temporary setbacks? Remember that the sun will shine again.',
        },
    },
    {
        id: 'judgement',
        name: 'Judgement',
        arcana: 'Major Arcana',
        image: require('../assets/tarot/judgement.png'),
        meaning: {
            upright: 'Reflection, reckoning, awakening, renewal',
            reversed: 'Self-doubt, refusal of self-examination',
        },
        interpretation: {
            upright: 'A time for reflection and self-evaluation. Embrace personal growth and transformation.',
            reversed: 'Are you avoiding self-reflection? It may be time to confront your past and embrace change.',
        },
    },
    {
        id: 'the_world',
        name: 'The World',
        arcana: 'Major Arcana',
        image: require('../assets/tarot/the_world.png'),
        meaning: {
            upright: 'Completion, accomplishment, travel, integration',
            reversed: 'Lack of closure, incomplete goals',
        },
        interpretation: {
            upright: 'A sense of completion and fulfillment. Celebrate your achievements and embrace new journeys.',
            reversed: 'Are you feeling unfulfilled or lacking closure? It may be time to reassess your goals and seek completion.',
        },
    },
    // Minor Arcana cards
    {
        id: 'ace_of_wands',
        name: 'Ace of Wands',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/ace_of_wands.png'),
        meaning: {
            upright: 'Inspiration, new opportunities, growth',
            reversed: 'Lack of direction, delays, missed opportunities',
        },
        interpretation: {
            upright: 'A burst of creative energy and new beginnings. Embrace your passions and take action.',
            reversed: 'Are you feeling stuck or lacking direction? It may be time to reassess your goals and find new inspiration.',
        },
    },
    {
        id: 'two_of_wands',
        name: 'Two of Wands',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/two_of_wands.png'),
        meaning: {
            upright: 'Planning, progress, discovery',
            reversed: 'Fear of change, lack of planning, indecision',
        },
        interpretation: {
            upright: 'You are on the brink of new discoveries. Plan your next steps with confidence.',
            reversed: 'Are you hesitating to take action? It may be time to overcome your fears and make a decision.',
        },
    },
    {
        id: 'three_of_wands',
        name: 'Three of Wands',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/three_of_wands.png'),
        meaning: {
            upright: 'Expansion, foresight, exploration',
            reversed: 'Lack of foresight, delays, obstacles',
        },
        interpretation: {
            upright: 'Your plans are starting to take shape. Embrace the opportunities that lie ahead.',
            reversed: 'Are you facing delays or obstacles? It may be time to reassess your plans and adapt.',
        },
    },
    {
        id: 'four_of_wands',
        name: 'Four of Wands',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/four_of_wands.png'),
        meaning: {
            upright: 'Celebration, harmony, homecoming',
            reversed: 'Lack of support, instability, conflict',
        },
        interpretation: {
            upright: 'A time for celebration and harmony. Embrace the joy of community and family.',
            reversed: 'Are you feeling unsupported or facing conflicts at home? It may be time to address these issues.',
        },
    },
    {
        id: 'five_of_wands',
        name: 'Five of Wands',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/five_of_wands.png'),
        meaning: {
            upright: 'Conflict, competition, rivalry',
            reversed: 'Avoidance of conflict, harmony, resolution',
        },
        interpretation: {
            upright: 'You may be facing competition or conflict. Embrace the challenge and find constructive ways to resolve it.',
            reversed: 'Are you avoiding necessary conflicts? It may be time to address issues head-on for resolution.',
        },
    },
    {
        id: 'six_of_wands',
        name: 'Six of Wands',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/six_of_wands.png'),
        meaning: {
            upright: 'Victory, recognition, success',
            reversed: 'Lack of recognition, defeat, egoism',
        },
        interpretation: {
            upright: 'A time of victory and recognition for your efforts. Celebrate your achievements with humility.',
            reversed: 'Are you feeling unrecognized or defeated? It may be time to reassess your goals and approach.',
        },
    },
    {
        id: 'seven_of_wands',
        name: 'Seven of Wands',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/seven_of_wands.png'),
        meaning: {
            upright: 'Perseverance, defense, maintaining control',
            reversed: 'Giving up, lack of confidence, feeling overwhelmed',
        },
        interpretation: {
            upright: 'Stand your ground and defend your position. Perseverance will lead to success.',
            reversed: 'Are you feeling overwhelmed or lacking confidence? It may be time to reassess your strategies.',
        },
    },
    {
      id: 'eight_of_wands',
      name: 'Eight of Wands',
      arcana: 'Minor Arcana',
      image: require('../assets/tarot/eight_of_wands.png'),
      meaning: {
          upright: 'Speed, action, quick decisions',
          reversed: 'Delays, frustration, lack of direction',
      },
      interpretation: {
          upright: 'Things are moving quickly. Be prepared for rapid changes and take decisive action.',
          reversed: 'Are you facing delays or frustration? It may be time to reasses your plans and find a new direction.',
        },
    },
    {
        id: 'nine_of_wands',
        name: 'Nine of Wands',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/nine_of_wands.png'),
        meaning: {
            upright: 'Resilience, persistence, boundaries',
            reversed: 'Exhaustion, paranoia, feeling overwhelmed',
        },
        interpretation: {
            upright: 'You have the strength to persevere through challenges. Set boundaries to protect your energy.',
            reversed: 'Are you feeling exhausted or paranoid? It may be time to take a break and recharge.',
        },
    },
    {
        id: 'ten_of_wands',
        name: 'Ten of Wands',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/ten_of_wands.png'),
        meaning: {
            upright: 'Burden, responsibility, hard work',
            reversed: 'Delegation, release of burdens, ease',
        },
        interpretation: {
            upright: 'You may be carrying a heavy burden. Consider delegating tasks or finding ways to lighten your load.',
            reversed: 'Are you ready to release some responsibilities? Embrace the ease that comes with letting go.',
        },
    },
    {
        id: 'page_of_wands',
        name: 'Page of Wands',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/page_of_wands.png'),
        meaning: {
            upright: 'Exploration, enthusiasm, creativity',
            reversed: 'Lack of direction, procrastination, apathy',
        },
        interpretation: {
            upright: 'Embrace your creative side and explore new ideas. Enthusiasm will lead to exciting opportunities.',
            reversed: 'Are you feeling apathetic or lacking direction? It may be time to reignite your passions.',
        },
    },
    {
        id: 'knight_of_wands',
        name: 'Knight of Wands',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/knight_of_wands.png'),
        meaning: {
            upright: 'Adventure, impulsiveness, passion',
            reversed: 'Recklessness, impatience, lack of direction',
        },
        interpretation: {
            upright: 'A time for adventure and passion. Embrace spontaneity but be mindful of impulsive decisions.',
            reversed: 'Are you being reckless or impatient? It may be time to find a clearer path forward.',
        },
    },
    {
      id: 'queen_of_wands',
      name: 'Queen of Wands',
      arcana: 'Minor Arcana',
      image: require('../assets/tarot/queen_of_wands.png'),
      meaning: {
          upright: 'Confidence, independence, charisma',
          reversed: 'Self-doubt, jealousy, insecurity',
      },
      interpretation: {
          upright: 'Embrace your confidence and independence. Your charisma will attract positive energy.',
          reversed: 'Are you struggling with self-doubt or jealousy? It may be time to focus on self-love and acceptance.',
      },
    },
    {
      id: 'king_of_wands',
      name: 'King of Wands',
      arcana: 'Minor Arcana',
      image: require('../assets/tarot/king_of_wands.png'),
      meaning: {
          upright: 'Leadership, vision, entrepreneurship',
          reversed: 'Impulsiveness, arrogance, lack of direction',
      },
      interpretation: {
          upright: 'You have the vision and leadership skills to achieve your goals. Embrace your entrepreneurial spirit.',
          reversed: 'Are you being impulsive or arrogant? It may be time to reassess your leadership style and find a clearer direction.',
      },
    },
    {
        id: 'ace_of_cups',
        name: 'Ace of Cups',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/ace_of_cups.png'),
        meaning: {
            upright: 'New love, emotional fulfillment, creativity',
            reversed: 'Blocked emotions, emptiness, lack of self-love',
        },
        interpretation: {
            upright: 'A new emotional beginning or creative inspiration is on the horizon. Embrace love and compassion.',
            reversed: 'Are you feeling emotionally blocked or empty? It may be time to focus on self-love and healing.',
        },
    },
    {
        id: 'two_of_cups',
        name: 'Two of Cups',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/two_of_cups.png'),
        meaning: {
            upright: 'Partnership, unity, mutual respect',
            reversed: 'Disharmony, imbalance, broken relationships',
        },
        interpretation: {
            upright: 'A strong partnership or connection is forming. Embrace unity and mutual respect.',
            reversed: 'Are you facing disharmony in a relationship? It may be time to address imbalances and communicate openly.',
        },
    },
    {
        id: 'three_of_cups',
        name: 'Three of Cups',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/three_of_cups.png'),
        meaning: {
            upright: 'Celebration, friendship, community',
            reversed: 'Overindulgence, isolation, lack of support',
        },
        interpretation: {
            upright: 'A time for celebration and connection with friends and community. Embrace the joy of togetherness.',
            reversed: 'Are you feeling isolated or overindulging? It may be time to reconnect with your support system and find balance.',
        },
    },
    {
        id: 'four_of_cups',
        name: 'Four of Cups',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/four_of_cups.png'),
        meaning: {
            upright: 'Apathy, contemplation, reevaluation',
            reversed: 'New opportunities, awareness, acceptance',
        },
        interpretation: {
            upright: 'You may be feeling apathetic or contemplative. Take time to reevaluate your emotions and desires.',
            reversed: 'Are you ready to embrace new opportunities? It may be time to open your heart and mind to acceptance.',
        },
    },
    {
        id: 'five_of_cups',
        name: 'Five of Cups',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/five_of_cups.png'),
        meaning: {
            upright: 'Loss, grief, disappointment',
            reversed: 'Acceptance, moving on, finding peace',
        },
        interpretation: {
            upright: 'You may be experiencing loss or disappointment. Allow yourself to grieve and process your emotions.',
            reversed: 'Are you ready to move on? Embrace acceptance and find peace in the lessons learned.',
        },
    },
    {
        id: 'six_of_cups',
        name: 'Six of Cups',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/six_of_cups.png'),
        meaning: {
            upright: 'Nostalgia, childhood memories, innocence',
            reversed: 'Stuck in the past, unrealistic expectations',
        },
        interpretation: {
            upright: 'Embrace the joy of nostalgia and childhood memories. Innocence can bring healing.',
            reversed: 'Are you stuck in the past? It may be time to let go of unrealistic expectations and focus on the present.',
        },
    },
    {
      id: 'seven_of_cups',
      name: 'Seven of Cups',
      arcana: 'Minor Arcana',
      image: require('../assets/tarot/seven_of_cups.png'),
      meaning: {
          upright: 'Choices, illusions, daydreams',
          reversed: 'Lack of clarity, confusion, poor choices',
      },
      interpretation: {
          upright: 'You may be faced with many choices or illusions. Take time to gain clarity before making decisions.',
          reversed: 'Are you feeling confused or making poor choices? It may be time to reassess your options and find clarity.',
      },
    },
    {
        id: 'eight_of_cups',
        name: 'Eight of Cups',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/eight_of_cups.png'),
        meaning: {
            upright: 'Walking away, seeking deeper meaning, introspection',
            reversed: 'Fear of change, avoidance, stagnation',
        },
        interpretation: {
            upright: 'It may be time to walk away from situations that no longer serve you. Seek deeper meaning and introspection.',
            reversed: 'Are you avoiding necessary changes? It may be time to confront your fears and embrace growth.',
        },
    },
    {
        id: 'nine_of_cups',
        name: 'Nine of Cups',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/nine_of_cups.png'),
        meaning: {
            upright: 'Contentment, satisfaction, emotional fulfillment',
            reversed: 'Dissatisfaction, unmet desires, overindulgence',
        },
        interpretation: {
            upright: 'A time of emotional fulfillment and contentment. Celebrate your achievements and enjoy the moment.',
            reversed: 'Are you feeling dissatisfied or overindulging? It may be time to reassess your desires and find true fulfillment.',
        },
    },
    {
        id: 'ten_of_cups',
        name: 'Ten of Cups',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/ten_of_cups.png'),
        meaning: {
            upright: 'Harmony, family, emotional bliss',
            reversed: 'Broken relationships, disharmony, lack of support',
        },
        interpretation: {
            upright: 'A time of harmony and emotional bliss with family and loved ones. Embrace the joy of togetherness.',
            reversed: 'Are you facing disharmony in relationships? It may be time to address issues and seek support.',
        },
    },
    {
      id: 'page_of_cups',
      name: 'Page of Cups',
      arcana: 'Minor Arcana',
      image: require('../assets/tarot/page_of_cups.png'),
      meaning: {
          upright: 'Creativity, intuition, new emotional experiences',
          reversed: 'Emotional immaturity, unrealistic expectations, lack of creativity',
      },
      interpretation: {
          upright: 'Embrace your creative side and explore new emotional experiences. Intuition will guide you.',
          reversed: 'Are you struggling with emotional immaturity or unrealistic expectations? It may be time to focus on self-growth.',
      },
    },
    {
      id: 'knight_of_cups',
      name: 'Knight of Cups',
      arcana: 'Minor Arcana',
      image: require('../assets/tarot/knight_of_cups.png'),
      meaning: {
          upright: 'Romance, charm, idealism',
          reversed: 'Unrealistic expectations, moodiness, lack of direction',
      },
      interpretation: {
          upright: 'A romantic or charming energy is present. Embrace your idealism but stay grounded.',
          reversed: 'Are you struggling with unrealistic expectations or moodiness? It may be time to find a clearer direction in your emotions.',
      },
    },
    {
        id: 'queen_of_cups',
        name: 'Queen of Cups',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/queen_of_cups.png'),
        meaning: {
            upright: 'Compassion, empathy, emotional intelligence',
            reversed: 'Emotional insecurity, lack of self-care, overemotional',
        },
        interpretation: {
            upright: 'Embrace your compassion and empathy. Your emotional intelligence will guide you in relationships.',
            reversed: 'Are you struggling with emotional insecurity or neglecting self-care? It may be time to focus on nurturing yourself.',
        },
        },
        {
        id: 'king_of_cups',
        name: 'King of Cups',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/king_of_cups.png'),
        meaning: {
            upright: 'Emotional balance, diplomacy, wisdom',
            reversed: 'Emotional manipulation, moodiness, lack of control',
        },
        interpretation: {
            upright: 'You possess emotional balance and wisdom. Use your diplomacy to navigate relationships.',
            reversed: 'Are you struggling with emotional manipulation or moodiness? It may be time to regain control over your emotions.',
        },
        },
    {
        id: 'ace_of_swords',
        name: 'Ace of Swords',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/ace_of_swords.png'),
        meaning: {
            upright: 'Clarity, truth, new ideas',
            reversed: 'Confusion, lack of clarity, dishonesty',
        },
        interpretation: {
            upright: 'A new idea or clarity is emerging. Embrace the truth and communicate openly.',
            reversed: 'Are you feeling confused or facing dishonesty? It may be time to seek clarity and confront the truth.',
        },
    },
    {
        id: 'two_of_swords',
        name: 'Two of Swords',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/two_of_swords.png'),
        meaning: {
            upright: 'Indecision, stalemate, difficult choices',
            reversed: 'Clarity, resolution, overcoming obstacles',
        },
        interpretation: {
            upright: 'You may be facing a difficult decision or stalemate. Take time to gain clarity before making a choice.',
            reversed: 'Are you ready to overcome obstacles and find resolution? Embrace clarity and move forward with confidence.',
        },
    },
    {
        id: 'three_of_swords',
        name: 'Three of Swords',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/three_of_swords.png'),
        meaning: {
            upright: 'Heartbreak, sorrow, emotional pain',
            reversed: 'Healing, forgiveness, moving on',
        },
        interpretation: {
            upright: 'You may be experiencing heartbreak or emotional pain. Allow yourself to grieve and heal.',
            reversed: 'Are you ready to forgive and move on? Embrace the healing process and find peace.',
        },
    },
    {
      id: 'four_of_swords',
      name: 'Four of Swords',
      arcana: 'Minor Arcana',
      image: require('../assets/tarot/four_of_swords.png'),
      meaning: {
          upright: 'Rest, recovery, contemplation',
          reversed: 'Burnout, stress, lack of rest',
      },
      interpretation: {
          upright: 'Take time for rest and recovery. Contemplate your next steps with a clear mind.',
          reversed: 'Are you feeling burnt out or stressed? It may be time to prioritize self-care and rest.',
      },
    },
    {
        id: 'five_of_swords',
        name: 'Five of Swords',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/five_of_swords.png'),
        meaning: {
            upright: 'Conflict, tension, betrayal',
            reversed: 'Resolution, compromise, moving on from conflict',
        },
        interpretation: {
            upright: 'You may be facing conflict or tension. Consider finding a resolution through compromise.',
            reversed: 'Are you ready to move on from conflict? Embrace resolution and let go of past grievances.',
        },
    },
    {
        id: 'six_of_swords',
        name: 'Six of Swords',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/six_of_swords.png'),
        meaning: {
            upright: 'Transition, moving on, travel',
            reversed: 'Stagnation, resistance to change, unresolved issues',
        },
        interpretation: {
            upright: 'A transition or journey is on the horizon. Embrace the opportunity to move on and find new horizons.',
            reversed: 'Are you resisting necessary changes? It may be time to confront unresolved issues and embrace growth.',
        },
    },
    {
      id: 'seven_of_swords',
      name: 'Seven of Swords',
      arcana: 'Minor Arcana',
      image: require('../assets/tarot/seven_of_swords.png'),
      meaning: {
          upright: 'Deception, strategy, stealth',
          reversed: 'Truth, honesty, coming clean',
      },
      interpretation: {
          upright: 'Be cautious of deception or dishonesty. Use strategy wisely but avoid unethical actions.',
          reversed: 'Are you ready to embrace the truth? It may be time to come clean and face the consequences.',
      },
    },
    {
        id: 'eight_of_swords',
        name: 'Eight of Swords',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/eight_of_swords.png'),
        meaning: {
            upright: 'Restriction, limitation, feeling trapped',
            reversed: 'Freedom, release from restrictions, new perspectives',
        },
        interpretation: {
            upright: 'You may be feeling restricted or trapped. Take time to reassess your situation and find a way out.',
            reversed: 'Are you ready to break free from limitations? Embrace new perspectives and find your freedom.',
        },
    },
    {
      id: 'nine_of_swords',
      name: 'Nine of Swords',
      arcana: 'Minor Arcana',
      image: require('../assets/tarot/nine_of_swords.png'),
      meaning: {
          upright: 'Anxiety, fear, nightmares',
          reversed: 'Release from anxiety, finding peace of mind',
      },
      interpretation: {
          upright: 'You may be experiencing anxiety or fear. Take time to confront your worries and find peace of mind.',
          reversed: 'Are you ready to release anxiety? Embrace the opportunity to find peace and clarity.',
      },
    },
    {
        id: 'ten_of_swords',
        name: 'Ten of Swords',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/ten_of_swords.png'),
        meaning: {
            upright: 'Betrayal, loss, painful endings',
            reversed: 'Recovery, regeneration, new beginnings',
        },
        interpretation: {
            upright: 'You may be facing a painful ending or betrayal. Allow yourself to grieve and heal.',
            reversed: 'Are you ready for recovery and new beginnings? Embrace the opportunity to regenerate and move forward.',
        },
    },
    {
      id: 'page_of_swords',
      name: 'Page of Swords',
      arcana: 'Minor Arcana',
      image: require('../assets/tarot/page_of_swords.png'),
      meaning: {
          upright: 'Curiosity, intellect, new ideas',
          reversed: 'Deception, manipulation, lack of clarity',
      },
      interpretation: {
          upright: 'Embrace your curiosity and intellect. New ideas are on the horizon.',
          reversed: 'Are you facing deception or lack of clarity? It may be time to seek the truth and confront manipulation.',
      },
    },
    {
      id: 'knight_of_swords',
      name: 'Knight of Swords',
      arcana: 'Minor Arcana',
      image: require('../assets/tarot/knight_of_swords.png'),
      meaning: {
          upright: 'Action, ambition, assertiveness',
          reversed: 'Haste, recklessness, lack of direction',
      },
      interpretation: {
          upright: 'Take decisive action and embrace your ambitions. Assertiveness will lead to success.',
          reversed: 'Are you being reckless or lacking direction? It may be time to find a clearer path forward.',
      },
    },
    {
        id: 'queen_of_swords',
        name: 'Queen of Swords',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/queen_of_swords.png'),
        meaning: {
            upright: 'Independence, perception, clear communication',
            reversed: 'Coldness, bitterness, lack of empathy',
        },
        interpretation: {
            upright: 'Embrace your independence and clear communication. Your perception will guide you in relationships.',
            reversed: 'Are you struggling with coldness or bitterness? It may be time to focus on empathy and understanding.',
        },
    },
    {
        id: 'king_of_swords',
        name: 'King of Swords',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/king_of_swords.png'),
        meaning: {
            upright: 'Intellect, authority, truth',
            reversed: 'Manipulation, tyranny, lack of clarity',
        },
        interpretation: {
            upright: 'You possess intellect and authority. Use your truth to guide others.',
            reversed: 'Are you struggling with manipulation or lack of clarity? It may be time to regain control over your thoughts and actions.',
        },
    },
    {
        id: 'ace_of_pentacles',
        name: 'Ace of Pentacles',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/ace_of_pentacles.png'),
        meaning: {
            upright: 'New financial opportunities, prosperity, stability',
            reversed: 'Missed opportunities, lack of resources, financial instability',
        },
        interpretation: {
            upright: 'A new financial opportunity or stable foundation is on the horizon. Embrace prosperity and stability.',
            reversed: 'Are you facing missed opportunities or financial instability? It may be time to reassess your resources and find new paths to prosperity.',
        },
    },
    {
        id: 'two_of_pentacles',
        name: 'Two of Pentacles',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/two_of_pentacles.png'),
        meaning: {
            upright: 'Balance, adaptability, time management',
            reversed: 'Overwhelm, disorganization, lack of balance',
        },
        interpretation: {
            upright: 'You are managing multiple responsibilities with grace. Embrace balance and adaptability.',
            reversed: 'Are you feeling overwhelmed or disorganized? It may be time to reassess your priorities and find balance.',
        },
    },
    {
        id: 'three_of_pentacles',
        name: 'Three of Pentacles',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/three_of_pentacles.png'),
        meaning: {
            upright: 'Collaboration, teamwork, skill development',
            reversed: 'Lack of teamwork, poor planning, miscommunication',
        },
        interpretation: {
            upright: 'Collaboration and teamwork will lead to success. Embrace skill development and shared goals.',
            reversed: 'Are you facing miscommunication or poor planning? It may be time to reassess your team dynamics and find common ground.',
        },
    },
    {
      id: 'four_of_pentacles',
      name: 'Four of Pentacles',
      arcana: 'Minor Arcana',
      image: require('../assets/tarot/four_of_pentacles.png'),
      meaning: {
          upright: 'Control, stability, holding on to resources',
          reversed: 'Greed, materialism, fear of loss',
      },
      interpretation: {
          upright: 'You may be holding on tightly to your resources. Consider finding a balance between control and generosity.',
          reversed: 'Are you struggling with greed or fear of loss? It may be time to let go and embrace abundance.',
      },
    },
    {
        id: 'five_of_pentacles',
        name: 'Five of Pentacles',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/five_of_pentacles.png'),
        meaning: {
            upright: 'Financial loss, hardship, isolation',
            reversed: 'Recovery, improvement, finding support',
        },
        interpretation: {
            upright: 'You may be facing financial loss or hardship. Seek support and focus on recovery.',
            reversed: 'Are you ready to improve your situation? Embrace recovery and find the support you need.',
        },
    },
    {
        id: 'six_of_pentacles',
        name: 'Six of Pentacles',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/six_of_pentacles.png'),
        meaning: {
            upright: 'Generosity, sharing, balance in giving and receiving',
            reversed: 'Inequality, selfishness, lack of generosity',
        },
        interpretation: {
            upright: 'A time for generosity and sharing. Find balance in giving and receiving.',
            reversed: 'Are you struggling with inequality or selfishness? It may be time to reassess your approach to generosity.',
        },
    },
    {
      id: 'seven_of_pentacles',
      name: 'Seven of Pentacles',
      arcana: 'Minor Arcana',
      image: require('../assets/tarot/seven_of_pentacles.png'),
      meaning: {
          upright: 'Patience, long-term success, assessment of progress',
          reversed: 'Lack of progress, impatience, poor planning',
      },
      interpretation: {
          upright: 'Take time to assess your progress and be patient. Long-term success is on the horizon.',
          reversed: 'Are you feeling impatient or facing a lack of progress? It may be time to reassess your plans and find new strategies.',
      },
    },
    {
        id: 'eight_of_pentacles',
        name: 'Eight of Pentacles',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/eight_of_pentacles.png'),
        meaning: {
            upright: 'Skill development, hard work, dedication',
            reversed: 'Lack of focus, poor quality work, burnout',
        },
        interpretation: {
            upright: 'Dedication to skill development will lead to success. Embrace hard work and focus.',
            reversed: 'Are you feeling burnt out or lacking focus? It may be time to reassess your work-life balance.',
        },
    },
    {
      id: 'nine_of_pentacles',
      name: 'Nine of Pentacles',
      arcana: 'Minor Arcana',
      image: require('../assets/tarot/nine_of_pentacles.png'),
      meaning: {
          upright: 'Financial independence, luxury, self-sufficiency',
          reversed: 'Financial setbacks, lack of self-sufficiency, dependence on others',
      },
      interpretation: {
          upright: 'A time of financial independence and luxury. Embrace self-sufficiency and enjoy the fruits of your labor.',
          reversed: 'Are you facing financial setbacks or dependence on others? It may be time to reassess your financial strategies and find independence.',
      },
    },
    {
        id: 'ten_of_pentacles',
        name: 'Ten of Pentacles',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/ten_of_pentacles.png'),
        meaning: {
            upright: 'Legacy, family, long-term success',
            reversed: 'Lack of stability, family conflicts, short-term focus',
        },
        interpretation: {
            upright: 'A time for building a legacy and enjoying family connections. Long-term success is within reach.',
            reversed: 'Are you facing family conflicts or lack of stability? It may be time to focus on long-term goals and find harmony.',
        },
    },
    {
      id: 'page_of_pentacles',
      name: 'Page of Pentacles',
      arcana: 'Minor Arcana',
      image: require('../assets/tarot/page_of_pentacles.png'),
      meaning: {
          upright: 'New financial opportunities, ambition, practicality',
          reversed: 'Lack of ambition, missed opportunities, poor planning',
      },
      interpretation: {
          upright: 'Embrace new financial opportunities with ambition and practicality. Your efforts will lead to success.',
          reversed: 'Are you missing out on opportunities or lacking ambition? It may be time to reassess your financial goals and plans.',
      },
    },
    {
      id: 'knight_of_pentacles',
      name: 'Knight of Pentacles',
      arcana: 'Minor Arcana',
      image: require('../assets/tarot/knight_of_pentacles.png'),
      meaning: {
          upright: 'Hard work, reliability, practicality',
          reversed: 'Stagnation, lack of progress, laziness',
      },
      interpretation: {
          upright: 'Dedication to hard work and reliability will lead to success. Embrace practicality in your endeavors.',
          reversed: 'Are you feeling stagnant or lazy? It may be time to find new motivation and take action towards your goals.',
      },
    },
    {
        id: 'queen_of_pentacles',
        name: 'Queen of Pentacles',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/queen_of_pentacles.png'),
        meaning: {
            upright: 'Nurturing, practicality, financial security',
            reversed: 'Neglecting responsibilities, financial instability, lack of nurturing',
        },
        interpretation: {
            upright: 'Embrace your nurturing side and focus on practicality. Financial security is within reach.',
            reversed: 'Are you neglecting responsibilities or facing financial instability? It may be time to reassess your priorities and find balance.',
        },
    },
    {
        id: 'king_of_pentacles',
        name: 'King of Pentacles',
        arcana: 'Minor Arcana',
        image: require('../assets/tarot/king_of_pentacles.png'),
        meaning: {
            upright: 'Wealth, stability, leadership',
            reversed: 'Greed, materialism, lack of stability',
        },
        interpretation: {
            upright: 'You possess the qualities of a strong leader. Embrace wealth and stability with humility.',
            reversed: 'Are you struggling with greed or materialism? It may be time to focus on stability and responsible leadership.',
        },
    },
];