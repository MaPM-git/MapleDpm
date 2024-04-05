package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class StrokeOfGods extends AttackSkill {
    public StrokeOfGods() {
        this.setName("선기 : 강림 괴력난신(신들의 일격)");
        this.setDamage(1870.0);
        this.setAttackCount(8L);
        this.setCooldown(1.5);
        this.addFinalDamage(1.6);   // 코어강화
    }
}
