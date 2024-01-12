package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SmashingMultipunchEnd extends AttackSkill {
    public SmashingMultipunchEnd() {
        this.setName("파쇄 연권(막타)");
        this.setDamage(1375.0);
        this.setAttackCount(15L);
        this.setDotDuration(1080L);
        this.setInterval(360L);
        this.setLimitAttackCount(3L);
        this.setRelatedSkill(new SmashingMultipunchEndDelay());
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
