package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class JaguarMaximumDelay extends AttackSkill {
    public JaguarMaximumDelay() {
        this.setName("재규어 맥시멈");
        this.setDelay(2160L);
        this.setRelatedSkill(new JaguarMaximumEnd());
    }
}
