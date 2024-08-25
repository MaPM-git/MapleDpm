package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChainArtsTakedown extends AttackSkill {
    public ChainArtsTakedown() {
        this.setName("체인아츠:테이크다운");
        this.setDamage(303.0);
        this.setAttackCount(2L);
        this.setDelayByAttackSpeed(540L);
        this.setCooldown(120.0 * 0.8);      // 체인아츠:테이크다운-쿨타임 리듀스
        //this.addFinalDamage(1.3);           // 연계
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        //this.setAddDamage(20L);             // 체인아츠:테이크다운-리인포스
        this.setRelatedSkill(new ChainArtsTakedownBeat());
    }
}
