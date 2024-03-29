package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class VoidBurstSlash extends AttackSkill implements VoidSkill {
    public VoidBurstSlash() {
        this.setName("보이드 버스트(참격)");
        this.setDamage(2310.0);
        this.setAttackCount(15L);
        this.setDelay(1200L);
        this.addFinalDamage(1.6);   // 코어강화
        this.setAddDamage(20L);     // 보이드-리인포스
        this.getMultiAttackInfo().add(1050L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
