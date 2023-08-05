package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MistEruption extends AttackSkill {
    public MistEruption() {
        this.setName("미스트 이럽션");
        this.setDamage(126.0);              // 쓸컴뱃 기준
        this.setCooldown((10 - 2) / 2.0);   // 미스트 이럽션-쿨타임 리듀스
        this.setAttackCount(10L);
        this.setLimitAttackCount(2L);
        this.setDotDuration(720L);
        this.setInterval(360L);
        this.addIgnoreDefenseList(41L);
        this.addFinalDamage(2.25);
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(10L);             // 미스트 이럽션-리인포스
        this.addIgnoreDefenseList(20L);     // 미스트 이럽션-이그노어 가드
        this.setRelatedSkill(new FlameSweepExplosion());
    }
}
