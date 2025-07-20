package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperArcher;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.link.CygnusBlessing;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Link;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.DexUnion;

import java.util.stream.Collectors;

public class Mercedes1Continuous extends Job {

    public Mercedes1Continuous() {
        // 기본
        super();
        this.setName("메르세데스(1초, 컨티)");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION1);

        this.setAscentDamage(2805250.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (318 + 196 + 72 + 246));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (318 + 196 + 72 + 246));

        passive = new Common();
        passive.setDescription("보조무기");
        //passive.addBossDamage(70L);
        //passive.addAttP(9L);
        passive.addBossDamage(30L);
        passive.addAttP(21L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("포텐셜 파워");
        passive.addDamage(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("샤프 에이밍");
        passive.addCriticalP(40.0);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("듀얼보우건 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("스피릿 인퓨젼");
        passive.addDamage(20L);
        passive.addCriticalP(15.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(30L);
        passive.addSubStat(30L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("이그니스 로어");
        passive.addFinalDamage(1.25);
        passive.addAtt(40L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("앤시언트 스피릿");
        passive.addAttP(31L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("듀얼보우건 엑스퍼트");
        passive.addAtt(31L);
        passive.addCriticalDamage(11.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("디펜스 브레이크");
        passive.addFinalDamage(1.21);
        passive.addIgnoreDefenseList(26L);
        passive.addBossDamage(20L);
        passive.addCriticalDamage(16.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어드밴스드 파이널 어택");
        passive.addAtt(21L);
        getPassiveList().add(passive);

        // 하이퍼
        passive = new Common();
        passive.setDescription("엘비쉬 블레싱");
        passive.addAtt(80L);
        passive.addFinalDamage(1.05);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-84L);
        this.addMainStat(10L);
        this.addSubStat(5L);

        this.setAbility(new BossCriticalAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        for (Link link : this.getLinkList()) {
            if (link instanceof CygnusBlessing) {
                this.getLinkList().remove(link);
                break;
            }
        }
        this.getLinkList().add(new PhantomInstinct());
        this.setUnion(new DexUnion());

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperArcher(this.getLevel()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("이그니스 로어 10중첩");
        doping.addFinalDamage(1.2);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("앤시언트 스피릿(콜렉터의 영약)");
        doping.addAttP(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("듀얼보우건 엑스퍼트(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("디펜스 브레이크(콜렉터의 영약)");
        doping.minusFinalDamage(1.21);
        doping.addFinalDamage(1.22);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
