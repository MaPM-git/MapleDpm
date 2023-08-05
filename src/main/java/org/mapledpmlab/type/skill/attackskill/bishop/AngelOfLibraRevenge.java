package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.bishop.AngelOfLibraRevengeBuff;
import org.mapledpmlab.type.skill.buffskill.bishop.BahamutBuff;

public class AngelOfLibraRevenge extends AttackSkill {
    public AngelOfLibraRevenge() {
        this.setName("엔젤 오브 리벤지(복수의 천사)");
        this.setDamage(1100.0);
        this.setAttackCount(10L);
        this.setInterval(3000L);
        this.setDotDuration(40000L);
        this.setRelatedSkill(new AngelOfLibraRevengeBuff());
        this.setAddDamage(-40L);        // 아케인 에임 소환수 미적용
        this.addFinalDamage(1.6);       // 코어강화
    }
}
