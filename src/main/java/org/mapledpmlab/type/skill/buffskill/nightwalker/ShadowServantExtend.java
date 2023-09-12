package org.mapledpmlab.type.skill.buffskill.nightwalker;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ShadowServantExtend extends BuffSkill {
    public ShadowServantExtend() {
        this.setName("쉐도우 서번트 익스텐드");
        this.setCooldown(60.0);
        this.setDelay(570L);
        this.setDuration(55L);      // 코어강화
    }
}
