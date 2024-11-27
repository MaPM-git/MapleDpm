package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FlameHaze extends AttackSkill {
    public FlameHaze() {
        this.setName("플레임 헤이즈");
        this.setDamage(335.0);
        this.setCooldown(10.0);         // 미스트 이럽션으로 초기화
        this.setAttackCount(15L);
        this.setDelayByAttackSpeed(1170L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new FlameHazeDot());
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
