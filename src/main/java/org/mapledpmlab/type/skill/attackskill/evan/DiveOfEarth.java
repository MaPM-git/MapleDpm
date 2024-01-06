package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DiveOfEarth extends AttackSkill {
    public DiveOfEarth() {
        this.setName("다이브 오브 어스");
        this.setDamage(375.0 + 625);
        this.setAttackCount(10L);
        this.setDotDuration(4000L);
        this.setInterval(480L);
        this.setLimitAttackCount(4L);
        this.setAddDamage(20L);         // 드래곤 다이브-어스 인핸스
        this.addFinalDamage(2.2);                   // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
