package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChainArtsTakedownFinish extends AttackSkill {
    public ChainArtsTakedownFinish() {
        this.setName("체인아츠:테이크다운(마무리)");
        this.setDamage(500.0);
        this.setAttackCount(10L);
        this.addFinalDamage(1.3);           // 연계
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);             // 체인아츠:테이크다운-리인포스
        this.getMultiAttackInfo().add(5000L - 540);
        this.setRelatedSkill(new ChainArtsTakedownWave());
    }
}
