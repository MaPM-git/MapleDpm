package org.mapledpmlab.type.skill.attackskill.soulmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FlareSlash extends AttackSkill {
    public FlareSlash() {
        this.setName("플레어 슬래시");
        this.setAttackCount(7L * 2);
        this.setDamage(1210.0);
        this.setCooldown(12.0);
        this.addFinalDamage(0.9);       // 마스터 오브 더 소드
        this.addFinalDamage(1.6);       // 코어강화
        this.getMultiAttackInfo().add(810L);
        this.setApplyCooldownReduction(false);
    }
}
