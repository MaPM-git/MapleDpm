package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.phantom.JokerHourglass;
import org.mapledpmlab.type.skill.buffskill.phantom.JokerSword;

public class JokerAfterDelay extends AttackSkill {
    public JokerAfterDelay() {
        this.setName("조커(후딜)");
        this.setDelay(300L);
        Long ran = (long) (Math.random() * 99 + 1);
        if (ran <= 40) {
            this.setRelatedSkill(new JokerSword());
        } else if (ran <= 60) {
            this.setRelatedSkill(new JokerHourglass());
        }
    }
}
