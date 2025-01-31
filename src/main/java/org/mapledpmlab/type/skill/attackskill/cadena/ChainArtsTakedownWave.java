package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.cadena.WeakPointConvergingAttackBind;

public class ChainArtsTakedownWave extends AttackSkill {
    public ChainArtsTakedownWave() {
        this.setName("체인아츠:테이크다운(충격파)");
        this.setDamage(1015.0);
        this.setAttackCount(4L);
        this.setDotDuration(5000L);
        this.setInterval(625L);
        this.setLimitAttackCount(8L);
        //this.addFinalDamage(1.3);           // 연계
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        //this.setAddDamage(20L);             // 체인아츠:테이크다운-리인포스
        this.setRelatedSkill(new WeakPointConvergingAttackBind());
        this.addIgnoreDefenseList(80L);
    }
}
