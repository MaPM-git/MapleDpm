package org.mapledpmlab.old.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SmashingMultipunch extends AttackSkill {
    public SmashingMultipunch() {
        this.setName("파쇄 연권");
        this.setDamage(550.0);
        this.setAttackCount(5L);
        this.setDelay(960L);
        this.setDotDuration(960L);
        this.setInterval(120L);
        this.setLimitAttackCount(8L);
        this.setRelatedSkill(new SmashingMultipunchEnd());
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
