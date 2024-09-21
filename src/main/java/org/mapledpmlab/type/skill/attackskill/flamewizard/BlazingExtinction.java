package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlazingExtinction extends AttackSkill {
    public BlazingExtinction() {
        this.setName("블레이징 익스팅션");
        this.setDamage(830.0);
        this.setAttackCount(12L + 1);   // 블레이징 익스팅션-애드 어택
        this.setCooldown(30.0);
        this.setDelayByAttackSpeed(870L);
        this.setAddDamage(20L);         // 블레이징 익스팅션-리인포스
        this.addFinalDamage(2.2);
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);      // 오버로드 마나
        this.getMultiAttackInfo().add(1120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
    }
}
