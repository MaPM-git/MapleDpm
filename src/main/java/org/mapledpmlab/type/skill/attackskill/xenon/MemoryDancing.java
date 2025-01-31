package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MemoryDancing extends AttackSkill {
    public MemoryDancing() {
        this.setName("메모리 댄싱");
        this.setAttackCount(7L * 2);
        this.setDamage(210.0);
        this.setCooldown(10.0);
        this.setAddDamage(20L);                 // 블레이드 댄싱-리인포스
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
