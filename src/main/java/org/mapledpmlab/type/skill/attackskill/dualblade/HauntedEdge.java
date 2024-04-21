package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HauntedEdge extends AttackSkill {
    public HauntedEdge() {
        this.setName("헌티드 엣지");
        this.setDamage(945.0);
        this.setAttackCount(8L);
        this.setCooldown(12.0);
        this.addIgnoreDefenseList(30L);
        this.addFinalDamage(1.6);           // 코어강화
        this.setApplyFinalAttack(true);
        this.addFinalDamage(0.85);           // 미러 이미징
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
    }
}
