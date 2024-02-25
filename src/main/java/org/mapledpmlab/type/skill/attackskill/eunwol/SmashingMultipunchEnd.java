package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SmashingMultipunchEnd extends AttackSkill {
    public SmashingMultipunchEnd() {
        this.setName("파쇄 연권(막타)");
        this.setDamage(1375.0);
        this.setAttackCount(15L);
        this.setDelay(1080L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.getMultiAttackInfo().add(270L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
