package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MistEruption extends AttackSkill {
    public MistEruption() {
        this.setName("미스트 이럽션");
        this.setDamage(215.0);
        this.setCooldown((10 - 2) / 2.0);   // 미스트 이럽션-쿨타임 리듀스
        this.setAttackCount(10L);
        this.addIgnoreDefenseList(45L);
        this.addFinalDamage(2.7);
        this.addFinalDamage(1.08);      // 오버로드 마나
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(10L);             // 미스트 이럽션-리인포스
        this.addIgnoreDefenseList(20L);     // 미스트 이럽션-이그노어 가드
        this.setRelatedSkill(new FlameSweepExplosion());
        this.setDelayByAttackSpeed(930L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
