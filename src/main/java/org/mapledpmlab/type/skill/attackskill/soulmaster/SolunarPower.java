package org.mapledpmlab.type.skill.attackskill.soulmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SolunarPower extends AttackSkill {
    public SolunarPower() {
        this.setName("솔루나 파워");
        this.setAttackCount(5L * 2);
        this.setDamage(6500.0);
        this.setCooldown(20.0);
        this.addFinalDamage(0.9);       // 마스터 오브 더 소드
        this.addFinalDamage(1.6);       // 코어강화
        this.getMultiAttackInfo().add(1050L);
        this.getMultiAttackInfo().add(1050L);
    }
}
