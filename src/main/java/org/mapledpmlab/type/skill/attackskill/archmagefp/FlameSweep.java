package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FlameSweep extends AttackSkill {
    public FlameSweep() {
        this.setName("플레임 스윕");
        this.setDamage(355.0);
        this.setAttackCount(7L + 1);    // 플레임 스윕-보너스 어택
        this.setDelayByAttackSpeed(780L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(10L);         // 플레임 스윕-리인포스
        this.setRelatedSkill(new FlameSweepDot());
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
