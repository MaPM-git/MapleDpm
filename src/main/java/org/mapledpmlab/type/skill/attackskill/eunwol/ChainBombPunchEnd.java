package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChainBombPunchEnd extends AttackSkill {
    public ChainBombPunchEnd() {
        this.setName("파쇄 연권(막타)");
        this.setDelayByAttackSpeed(1080L);
        this.setAttackCount(14L);
        this.setDamage(880.0);
        this.addFinalDamage(1.6);           // 코어 강화
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
