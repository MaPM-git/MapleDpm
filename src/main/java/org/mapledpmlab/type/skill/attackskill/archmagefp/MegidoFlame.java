package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MegidoFlame extends AttackSkill {
    public MegidoFlame() {
        this.setName("메기도 플레임");
        this.setDamage(660.0);
        this.setAttackCount(5L);
        this.setCooldown(50.0);
        this.setDelayByAttackSpeed(810L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new MegidoFlameDot());
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
